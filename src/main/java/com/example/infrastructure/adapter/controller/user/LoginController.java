package com.example.infrastructure.adapter.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.core.usecase.user.GetLoginPageUsecase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {

    private final GetLoginPageUsecase getLoginPage;

    @GetMapping
    public void getPage() {

        getLoginPage.execute(null);
    }
}
