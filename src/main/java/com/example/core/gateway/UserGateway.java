package com.example.core.gateway;

import com.example.core.entity.User;

public interface UserGateway {

    public User save(User user);
    public User findByUsername(String username);
}
