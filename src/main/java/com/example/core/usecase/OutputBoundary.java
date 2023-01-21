package com.example.core.usecase;

public interface OutputBoundary<O extends InputBoundary.ResponseModel> {

    public void present(O o);
}
