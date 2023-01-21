package com.example.core.presenter;

import com.example.core.usecase.InputBoundary;

public interface OutputBoundary<R extends InputBoundary.ResponseModel> {

    public void present(R model);
}
