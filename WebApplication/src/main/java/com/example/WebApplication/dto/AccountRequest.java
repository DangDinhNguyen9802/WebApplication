package com.example.WebApplication.dto;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AccountRequest {
    private String userName;
    private String email;
    private String password;
}
