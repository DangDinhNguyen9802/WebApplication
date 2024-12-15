package com.example.WebApplication.dto;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AccountRequest {
    private String username;
    private String email;
    private String password;
}
