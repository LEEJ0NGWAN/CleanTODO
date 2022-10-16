package com.example.core.entity;

import java.sql.Timestamp;

public class User {

    private String username;
    private String password;
    private Timestamp createdAt;

    private User() {}

    public static User with() { return new User(); }
    public User username(String value) { this.username = value; return this; }
    public User password(String value) { this.password = value; return this; }
    public User createdAt(Timestamp time) { this.createdAt = time; return this; }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Timestamp getCreatedAt() { return createdAt; }
}
