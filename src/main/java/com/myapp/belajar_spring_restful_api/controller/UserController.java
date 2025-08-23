package com.myapp.belajar_spring_restful_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.belajar_spring_restful_api.model.ApiResponse;
import com.myapp.belajar_spring_restful_api.model.RegisterUserRequest;
import com.myapp.belajar_spring_restful_api.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    
    public ApiResponse<String> register(@RequestBody RegisterUserRequest request){
        userService.register(request);

        return ApiResponse.<String>builder().data("OK").build();
    }


    
}
