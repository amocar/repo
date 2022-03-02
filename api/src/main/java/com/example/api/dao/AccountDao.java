package com.example.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.example.api.entities.Account;
import com.example.api.enums.AccountType;
import com.example.api.repositories.AccountRepository;

@Repository
public class AccountDao {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	public Account save(Object t) {
		return accountRepository.save((Account) t);
	}

	public Optional<Account> findById(long id) {
		return accountRepository.findById(id);
	}
	//initial population
	@Bean
	CommandLineRunner initDatabase(AccountRepository repository) {

		return args -> {
			System.out.println(
					" save " + repository.save(new Account("Customer 1", "092412222", AccountType.Y,"qwe@yahoo.com","LPC")).getCustomerName());
			System.out.println(
					" save" + repository.save(new Account("Customer 2", "09241245455", AccountType.C,"asda@gmail.com","USA")).getCustomerName());
		};
	}

}
