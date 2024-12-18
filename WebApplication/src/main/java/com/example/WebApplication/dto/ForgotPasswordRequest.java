package com.example.WebApplication.dto;

import lombok.*;

@Data
public class ForgotPasswordRequest {
    private String username;
    private String email;
    
}
