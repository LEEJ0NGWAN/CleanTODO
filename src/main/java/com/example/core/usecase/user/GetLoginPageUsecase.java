package com.example.core.usecase.user;

import com.example.core.usecase.InputBoundary;

public abstract class GetLoginPageUsecase
implements InputBoundary<GetLoginPageUsecase.Request, GetLoginPageUsecase.Response> {

    public static class Request implements InputBoundary.RequestModel {

        private String message;

        private Request() {}

        public static Request with() { return new Request(); }

        public Request message(String v) { message = v; return this; }
        public String getMessage() { return message; }
    }

    public static class Response implements InputBoundary.ResponseModel {

        private String message;

        private Response(String message) { this.message = message; }

        public static Response withMessage(String v) { return new Response(v); }
        public String getMessage() { return this.message; }
    }
}
