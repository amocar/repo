package com.example.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
