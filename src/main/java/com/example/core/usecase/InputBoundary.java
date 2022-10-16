package com.example.core.usecase;

public interface InputBoundary
<I extends InputBoundary.InputModel, O extends InputBoundary.OutputModel> {

    public O execute(I input);

    public interface InputModel {}
    public interface OutputModel {}
}
