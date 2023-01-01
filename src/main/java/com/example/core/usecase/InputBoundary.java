package com.example.core.usecase;

public interface InputBoundary
<I extends InputBoundary.RequestModel, O extends InputBoundary.ResponseModel> {

    public O execute(I input);

    public interface RequestModel {}
    public interface ResponseModel {}
}
