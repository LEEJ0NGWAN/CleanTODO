package com.example.core.presenter;

import com.example.core.usecase.user.GetLoginPageUsecase;

public abstract class LoginPagePresenter
implements OutputBoundary<GetLoginPageUsecase.Response> {}
