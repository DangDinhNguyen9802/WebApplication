package com.example.WebApplication.dto;

import lombok.*;

@Data
public class UpdatePasswordRequest {
    private String userName;
    private String email;
    private String newPassword;
}
