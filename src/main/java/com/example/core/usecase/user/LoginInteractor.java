package com.example.core.usecase.user;

import com.example.core.presenter.LoginPresenter;

public class LoginInteractor extends LoginUsecase {

    private final LoginPresenter presenter;

    public LoginInteractor(LoginPresenter presenter) {

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
