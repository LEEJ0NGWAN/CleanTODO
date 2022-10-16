package com.example.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.infrastructure.jpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    public User findByUsername(String username);
}
