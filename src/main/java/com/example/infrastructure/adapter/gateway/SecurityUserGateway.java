package com.example.infrastructure.adapter.gateway;

import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.core.entity.User;
import com.example.core.gateway.UserGateway;
import com.example.infrastructure.jpa.user.UserEntity;
import com.example.infrastructure.jpa.user.UserRepository;
import com.example.infrastructure.security.UserPrincipal;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityUserGateway implements UserGateway, UserDetailsService {

    private final UserRepository repository;

    @Override
    public User findByUsername(String username) {

        return Optional
        .ofNullable(username)
        .map(repository::findByUsername)
        .map(UserEntity::getDomainFromThis)
        .orElse(null);
    }

    @Override
    public User save(User user) {

        return Optional
        .ofNullable(user)
        .map(UserEntity::fromThis)
        .map(repository::save)
        .map(UserEntity::getDomainFromThis)
        .orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {

        return Optional
        .ofNullable(username)
        .map(repository::findByUsername)
        .map(UserPrincipal::fromThis)
        .orElseThrow(() -> new BadCredentialsException(username));
    }
}
