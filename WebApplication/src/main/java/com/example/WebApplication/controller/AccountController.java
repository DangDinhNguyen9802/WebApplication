package com.example.WebApplication.controller;

import com.example.WebApplication.dto.AccountRequest;
import com.example.WebApplication.dto.SignInRequest;
import com.example.WebApplication.dto.UpdatePasswordRequest;
import com.example.WebApplication.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.example.WebApplication.dto.AccountResponse;
import com.example.WebApplication.dto.ForgotPasswordRequest;
import com.example.WebApplication.services.impl.AccountService;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/sign-up")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest request) {
        AccountResponse response = accountService.createAccount(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AccountResponse> signInAccount(@RequestBody SignInRequest request) {
        AccountResponse response = accountService.signInAccount(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> verifyAccount(@RequestBody ForgotPasswordRequest request) {
        boolean isValid = accountService.verifyAccount(request);

        if (isValid)
            return ResponseEntity.ok("Account verified. You can now update your new password!");
        else
            return ResponseEntity.status(404).body("Account not found");
    }
    
    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest request) {
        boolean isUpdated = accountService.updatePassword(request);

        if(isUpdated)
            return ResponseEntity.ok("Password updated successfully");
        else
            return ResponseEntity.status(404).body("Failed to update password. Account not found");
    }
    

}
