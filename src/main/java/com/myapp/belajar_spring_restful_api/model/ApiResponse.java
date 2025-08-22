package com.myapp.belajar_spring_restful_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ApiResponse<T> {
    private T data;

    private String errors;
}
