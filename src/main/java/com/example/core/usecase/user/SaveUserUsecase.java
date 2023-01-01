package com.example.core.usecase.user;

import com.example.core.usecase.InputBoundary;

public abstract class SaveUserUsecase
implements InputBoundary<SaveUserUsecase.Request, SaveUserUsecase.Response> {

    public static class Request implements InputBoundary.RequestModel {

        private String username;
        private String password;

        private Request() {}

        public String getUsername() { return username; }
        public String getPassword() { return password; }

        public static Request with() { return new Request(); }
        public Request username(String value) { this.username = value; return this; }
        public Request password(String value) { this.password = value; return this; }
    }

    public static class Response implements InputBoundary.ResponseModel {

        private boolean result;
        private String message;

        private Response() {}

        public static Response with() { return new Response(); }
        public Response result(boolean value) { this.result = value; return this; }
        public Response message(String value) { this.message = value; return this; }

        public boolean getResult() { return this.result; }
        public String getMessage() { return this.message; }
    }
}
