package com.example.infrastructure.adapter.gateway;

import java.util.Optional;

import javax.transaction.Transactional;

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
public class JpaUserGateway implements UserGateway, UserDetailsService {

    private final UserRepository repository;

    public static UserEntity fromThisDomain(User user) {

        if (user == null) return null;

        return UserEntity
        .builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .createdAt(user.getCreatedAt())
        .build();
    }

    public static User fromThisEntity(UserEntity entity) {

        if (entity == null) return null;

        return User
        .with()
        .username(entity.getUsername())
        .password(entity.getPassword())
        .createdAt(entity.getCreatedAt());
    }

    @Override
    public User findByUsername(String username) {

        return Optional
        .ofNullable(username)
        .map(repository::findByUsername)
        .map(JpaUserGateway::fromThisEntity)
        .orElse(null);
    }

    @Override
    @Transactional
    public User save(User user) {

        return Optional
        .ofNullable(user)
        .map(JpaUserGateway::fromThisDomain)
        .map(repository::save)
        .map(JpaUserGateway::fromThisEntity)
        .orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return Optional
        .ofNullable(username)
        .map(repository::findByUsername)
        .map(UserPrincipal::fromThis)
        .orElseThrow(() -> new BadCredentialsException(username));
    }
}
