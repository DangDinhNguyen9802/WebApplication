package com.example.WebApplication.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccountResponse {
    private boolean success;
    private String message;
}