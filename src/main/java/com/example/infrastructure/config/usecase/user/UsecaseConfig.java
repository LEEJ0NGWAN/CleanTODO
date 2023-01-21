package com.example.infrastructure.config.usecase.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.core.gateway.UserGateway;
import com.example.core.presenter.LoginPresenter;
import com.example.core.usecase.user.LoginInteractor;
import com.example.core.usecase.user.LoginUsecase;
import com.example.core.usecase.user.SaveUserInteractor;
import com.example.core.usecase.user.SaveUserUsecase;
import com.example.core.usecase.user.SearchUserInteractor;
import com.example.core.usecase.user.SearchUserUsecase;

@Configuration
public class UsecaseConfig {

    @Bean
    public LoginUsecase loginUsecase(LoginPresenter presenter) {

        return new LoginInteractor(presenter);
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
