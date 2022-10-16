package com.example.core.usecase.user;

import java.sql.Timestamp;

import com.example.core.entity.User;
import com.example.core.gateway.UserGateway;

public class SaveUserInteractor extends SaveUserUsecase {

    private final UserGateway gateway;

    public SaveUserInteractor(UserGateway gateway) {

        this.gateway = gateway;
    }

    @Override
    public Output execute(Input input) {

        if (input == null)
        return Output
        .with()
        .result(false)
        .message("invalid input");


        final String username = input.getUsername();
        final String password = input.getPassword();

        if (username == null || "".equals(username))
        return Output
        .with()
        .result(false)
        .message("invalid username");

        if (password == null || "".equals(password))
        return Output
        .with()
        .result(false)
        .message("invalid password");

        final User user = User
        .with()
        .username(username)
        .password(password)
        .createdAt(new Timestamp(System.currentTimeMillis()));

        final User result = gateway.save(user);

        if (result == null)
        return Output
        .with()
        .result(false)
        .message("save failed");

        return Output
        .with()
        .result(true)
        .message(username);
    }
}
