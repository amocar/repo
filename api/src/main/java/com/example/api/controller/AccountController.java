package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entities.Account;
import com.example.api.services.AccountService;
import com.example.api.dto.ResponseDTO;

@RestController
public class AccountController {
	static final String version = "/v1";
	@Autowired
	private AccountService accountService;

	@GetMapping(version + "/accounts")
	List<Account> all() {
		return accountService.getAll();
	}

	@PostMapping(version + "/accounts")
	ResponseDTO newEmployee(@RequestBody Account newAccount) {
		return accountService.save(newAccount);
	}

	@GetMapping(version + "/accounts/{id}")
	ResponseDTO getOne(@PathVariable Long id) {
		return accountService.findById(id);
	}

}
