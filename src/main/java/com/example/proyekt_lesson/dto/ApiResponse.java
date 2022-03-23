package com.example.proyekt_lesson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean active;
    private Object object;

    public ApiResponse(String message, boolean active) {
        this.message = message;
        this.active = active;
    }
}
