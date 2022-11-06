package com.example.infrastructure.jpa.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.core.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private Timestamp createdAt;

    public static UserEntity fromThis(User user) {

        if (user == null) return null;

        return UserEntity
        .builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .createdAt(user.getCreatedAt())
        .build();
    }

    public static User getDomainFromThis(UserEntity entity) {

        if (entity == null) return null;

        return User
        .with()
        .username(entity.username)
        .password(entity.password)
        .createdAt(entity.createdAt);
    }
}
