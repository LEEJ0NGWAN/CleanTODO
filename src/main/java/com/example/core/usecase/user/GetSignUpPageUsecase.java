package com.example.core.usecase.user;

import com.example.core.usecase.InputBoundary;

public abstract class GetSignUpPageUsecase
implements InputBoundary<GetSignUpPageUsecase.Request, GetSignUpPageUsecase.Response> {

    public static class Request implements InputBoundary.RequestModel {

        private String message;

        private Request(String message) { this.message = message; }

        public static Request withMessage(String v) { return new Request(v); }
        public String getMessage() { return message; }
    }

    public static class Response implements InputBoundary.ResponseModel {

        private String message;

        private Response(String message) { this.message = message; }

        public static Response withMessage(String v) { return new Response(v); }
        public String getMessage() { return this.message; }
    }
}
