package com.example.infrastructure.config.usecase.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.core.gateway.UserGateway;
import com.example.core.presenter.LoginPagePresenter;
import com.example.core.presenter.SignUpPagePresenter;
import com.example.core.usecase.user.GetLoginPageInteractor;
import com.example.core.usecase.user.GetLoginPageUsecase;
import com.example.core.usecase.user.GetSignUpPageInteractor;
import com.example.core.usecase.user.GetSignUpPageUsecase;
import com.example.core.usecase.user.SaveUserInteractor;
import com.example.core.usecase.user.SaveUserUsecase;
import com.example.core.usecase.user.SearchUserInteractor;
import com.example.core.usecase.user.SearchUserUsecase;

@Configuration
public class UsecaseConfig {

    @Bean
    public GetSignUpPageUsecase signUpPageUsecase(SignUpPagePresenter presenter) {

        return new GetSignUpPageInteractor(presenter);
    }

    @Bean
    public GetLoginPageUsecase loginPageUsecase(LoginPagePresenter presenter) {

        return new GetLoginPageInteractor(presenter);
    }

    @Bean
    public SaveUserUsecase saveUserUsecase(UserGateway gateway) {

        return new SaveUserInteractor(gateway);
    }

    @Bean
    public SearchUserUsecase searchUserUsecase(UserGateway gateway) {

        return new SearchUserInteractor(gateway);
    }
}
