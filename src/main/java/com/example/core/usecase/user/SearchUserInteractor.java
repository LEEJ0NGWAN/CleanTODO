package com.example.core.usecase.user;

import com.example.core.entity.User;
import com.example.core.gateway.UserGateway;

public class SearchUserInteractor extends SearchUserUsecase {

    private final UserGateway gateway;

    public SearchUserInteractor(UserGateway gateway) {

        this.gateway = gateway;
    }

    @Override
    public Response execute(Request data) {

        if (data == null || data.getUsername() == null)
        return null;

        final User user = gateway.findByUsername(data.getUsername());

        if (user == null) return null;

        return Response
        .with()
        .username(user.getUsername())
        .password(user.getPassword())
        .createdAt(user.getCreatedAt());
    }
}
