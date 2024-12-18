package com.example.WebApplication.dto;

import lombok.*;

@Data
public class UpdatePasswordRequest {
    private String username;
    private String email;
    private String newPassword;
}
