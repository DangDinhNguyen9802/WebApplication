package com.example.WebApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebApplication.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>{
    Boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<Account> findByUsername(String username);
    Optional<Account> findByUsernameAndEmail (String username, String email);
}