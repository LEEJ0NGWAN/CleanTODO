package com.example.core.usecase;

public interface OutputBoundary<O extends InputBoundary.ResponseModel, P> {

    public P present(O o);
}
