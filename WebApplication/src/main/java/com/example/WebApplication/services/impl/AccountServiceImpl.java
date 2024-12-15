package com.example.WebApplication.services.impl;

import com.example.WebApplication.dto.AccountRequest;
import com.example.WebApplication.dto.AccountResponse;
import com.example.WebApplication.dto.ForgotPasswordRequest;
import com.example.WebApplication.dto.SignInRequest;
import com.example.WebApplication.dto.UpdatePasswordRequest;
import com.example.WebApplication.entity.Account;
import com.example.WebApplication.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountResponse createAccount(AccountRequest request) {
        if(accountRepository.existsByEmail(request.getEmail())) {
            return new AccountResponse(false, "Email already exists.");
        }
        if(accountRepository.existsByUsername((request.getUsername()))) {
            return new AccountResponse(false, "Username already taken.");
        }

        Account account = new Account();

        account.setUsername(request.getUsername());
        account.setEmail(request.getEmail());
        account.setPassword(request.getPassword());

        accountRepository.save(account);

        return new AccountResponse(true, "Account created successfully!");
    }

    @Override
    public AccountResponse signInAccount(SignInRequest request) {
        return accountRepository.findByUsername(request.getUsername())
                .map(account -> {
                    if (account.getPassword().equals(request.getPassword()))
                        return new AccountResponse(true, "Login successfully!");
                    else
                        return new AccountResponse(false, "Password is not true!");
                })
                .orElse(new AccountResponse(false, "Invalid username!"));
    }

    @Override
    public boolean verifyAccount(ForgotPasswordRequest request) {
        Optional<Account> account = accountRepository.findByUsernameAndEmail(request.getUsername(), request.getEmail());
        return account.isPresent();
    }

    @Override
    public boolean updatePassword(UpdatePasswordRequest request) {
        Optional<Account> account = accountRepository.findByUsernameAndEmail(request.getUsername(), request.getEmail());
        if(account.isPresent()) {
            Account updatedAccount = account.get();
            updatedAccount.setPassword(request.getNewPassword());
            accountRepository.save(updatedAccount);
            return true;
        }
        return false;
    }
}
