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
    public Response execute(Request data) {

        if (data == null)
        return Response
        .with()
        .result(false)
        .message("invalid input");


        final String username = data.getUsername();
        final String password = data.getPassword();

        if (username == null || "".equals(username))
        return Response
        .with()
        .result(false)
        .message("invalid username");

        if (password == null || "".equals(password))
        return Response
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
        return Response
        .with()
        .result(false)
        .message("save failed");

        return Response
        .with()
        .result(true)
        .message(username);
    }
}
