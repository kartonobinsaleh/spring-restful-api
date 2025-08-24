package com.myapp.belajar_spring_restful_api.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.belajar_spring_restful_api.model.ApiResponse;
import com.myapp.belajar_spring_restful_api.model.LoginUserRequest;
import com.myapp.belajar_spring_restful_api.model.TokenResponse;
import com.myapp.belajar_spring_restful_api.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class AuthContoller {

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/api/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<TokenResponse> login(@RequestBody LoginUserRequest request) {
        TokenResponse tokenResponse = authService.login(request);

        return ApiResponse.<TokenResponse>builder().data(tokenResponse).build();
    }
}
