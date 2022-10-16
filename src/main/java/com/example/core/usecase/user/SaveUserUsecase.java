package com.example.core.usecase.user;

import java.sql.Timestamp;

import com.example.core.usecase.InputBoundary;

public abstract class SaveUserUsecase
implements InputBoundary<SaveUserUsecase.Input, SaveUserUsecase.Output> {

    public static class Input implements InputBoundary.InputModel {

        private String username;
        private String password;
        private Timestamp createdAt;

        private Input() {}

        public String getUsername() { return username; }
        public String getPassword() { return password; }
        public Timestamp getCreatedAt() { return createdAt; }

        public static Input with() { return new Input(); }
        public Input username(String value) { this.username = value; return this; }
        public Input password(String value) { this.password = value; return this; }
        public Input createdAt(Timestamp time) { this.createdAt = time; return this; }
    }

    public static class Output implements InputBoundary.OutputModel {

        private boolean result;
        private String message;

        private Output() {}

        public static Output with() { return new Output(); }
        public Output result(boolean value) { this.result = value; return this; }
        public Output message(String value) { this.message = value; return this; }

        public boolean getResult() { return this.result; }
        public String getMessage() { return this.message; }
    }
}
