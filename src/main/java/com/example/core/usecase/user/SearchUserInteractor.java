package com.example.core.usecase.user;

import com.example.core.entity.User;
import com.example.core.gateway.UserGateway;

public class SearchUserInteractor extends SearchUserUsecase {

    private final UserGateway gateway;

    public SearchUserInteractor(UserGateway gateway) {

        this.gateway = gateway;
    }

    @Override
    public Output execute(Input input) {

        if (input == null || input.getUsername() == null)
        return null;

        final User user = gateway.findByUsername(input.getUsername());

        if (user == null) return null;

        return Output
        .with()
        .username(user.getUsername())
        .password(user.getPassword())
        .createdAt(user.getCreatedAt());
    }
}
