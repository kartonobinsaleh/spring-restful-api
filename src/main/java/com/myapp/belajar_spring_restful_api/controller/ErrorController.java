package com.myapp.belajar_spring_restful_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.myapp.belajar_spring_restful_api.model.ApiResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<String>> constrainViolationException(ConstraintViolationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.<String>builder().errors(exception.getMessage()).build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiResponse<String>> ApiException(ResponseStatusException exception) {
        return ResponseEntity.status(exception.getStatusCode())
                .body(ApiResponse.<String>builder().errors(exception.getReason()).build());
    }
}
