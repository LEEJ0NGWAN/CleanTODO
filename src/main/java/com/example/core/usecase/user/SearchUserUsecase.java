package com.example.core.usecase.user;

import java.sql.Timestamp;

import com.example.core.usecase.InputBoundary;

public abstract class SearchUserUsecase
implements InputBoundary<SearchUserUsecase.Input, SearchUserUsecase.Output> {

    public static class Input implements InputBoundary.InputModel {

        private String username;

        private Input(String username) { this.username = username; }

        public static Input withUsername(String value) { return new Input(value); }

        public String getUsername() { return username; }
    }

    public static class Output implements InputBoundary.OutputModel {

        private String username;
        private String password;
        private Timestamp createdAt;

        private Output() {}

        public String getUsername() { return username; }
        public String getPassword() { return password; }
        public Timestamp getCreatedAt() { return createdAt; }

        public static Output with() { return new Output(); }
        public Output username(String value) { this.username = value; return this; }
        public Output password(String value) { this.password = value; return this; }
        public Output createdAt(Timestamp time) { this.createdAt = time; return this; }
    }
}
