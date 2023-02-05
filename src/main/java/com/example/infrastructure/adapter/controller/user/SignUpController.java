package com.example.infrastructure.adapter.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.core.usecase.user.GetSignUpPageUsecase;
import com.example.infrastructure.vo.SignUpRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/signup")
@RequiredArgsConstructor
public class SignUpController {

    private final GetSignUpPageUsecase getSignUpPage;

    @GetMapping
    public void getPage() {

        getSignUpPage.execute(null);
    }

    @PostMapping
    public String signUp(@ModelAttribute SignUpRequest request) {

        log.info("{}", request);

        return "WIP";
    }
}
