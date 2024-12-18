package com.example.WebApplication.services.impl;

import com.example.WebApplication.dto.AccountRequest;
import com.example.WebApplication.dto.AccountResponse;
import com.example.WebApplication.dto.ForgotPasswordRequest;
import com.example.WebApplication.dto.SignInRequest;
import com.example.WebApplication.dto.UpdatePasswordRequest;

public interface AccountService {
    public AccountResponse createAccount(AccountRequest request);

    public AccountResponse signInAccount(SignInRequest request);

    public boolean verifyAccount(ForgotPasswordRequest request);

    public boolean updatePassword(UpdatePasswordRequest request);

}
