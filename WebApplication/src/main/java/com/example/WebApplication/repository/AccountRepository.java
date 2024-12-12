package com.example.WebApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WebApplication.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>{
    Boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    Optional<Account> findByUserName(String userName);
    Optional<Account> findByUserNameAndEmail (String userName, String email);
}