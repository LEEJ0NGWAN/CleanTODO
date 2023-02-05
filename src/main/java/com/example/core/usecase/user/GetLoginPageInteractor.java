package com.example.core.usecase.user;

import com.example.core.presenter.LoginPagePresenter;

public class GetLoginPageInteractor extends GetLoginPageUsecase {

    private final LoginPagePresenter presenter;

    public GetLoginPageInteractor(LoginPagePresenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public Response execute(Request input) {

        final String message = input==null? null: input.getMessage();

        final Response response = Response.withMessage(message);

        presenter.present(response);

        return response;
    }
}
