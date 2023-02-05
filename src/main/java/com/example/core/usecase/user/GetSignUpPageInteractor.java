package com.example.core.usecase.user;

import com.example.core.presenter.SignUpPagePresenter;

public class GetSignUpPageInteractor extends GetSignUpPageUsecase {

    private final SignUpPagePresenter presenter;

    public GetSignUpPageInteractor(SignUpPagePresenter presenter) {

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
