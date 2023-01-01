package com.example.core.usecase.user;

import java.sql.Timestamp;

import com.example.core.usecase.InputBoundary;

public abstract class SearchUserUsecase
implements InputBoundary<SearchUserUsecase.Request, SearchUserUsecase.Response> {

    public static class Request implements InputBoundary.RequestModel {

        private String username;

        private Request(String username) { this.username = username; }

        public static Request withUsername(String value) { return new Request(value); }

        public String getUsername() { return username; }
    }

    public static class Response implements InputBoundary.ResponseModel {

        private String username;
        private String password;
        private Timestamp createdAt;

        private Response() {}

        public String getUsername() { return username; }
        public String getPassword() { return password; }
        public Timestamp getCreatedAt() { return createdAt; }

        public static Response with() { return new Response(); }
        public Response username(String value) { this.username = value; return this; }
        public Response password(String value) { this.password = value; return this; }
        public Response createdAt(Timestamp time) { this.createdAt = time; return this; }
    }
}
