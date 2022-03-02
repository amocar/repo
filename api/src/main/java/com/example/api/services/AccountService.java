package com.example.api.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.dao.AccountDao;
import com.example.api.dto.ResponseDTO;
import com.example.api.entities.Account;

@Service
public class AccountService {

	private static final String CREATED = "201", FOUND = "302", NFOUND = "401", REQUIRED = "400";
	Map<String, String> sMap = new HashMap<String, String>();
	{
		sMap.put(CREATED, "Customer account created.");
		sMap.put(FOUND, "Customer Account found.");
		sMap.put(REQUIRED, " is required field.");
		sMap.put(NFOUND, "Customer not Found.");
	}
	@Autowired
	private AccountDao accountDao;

	public List<Account> getAll() {
		return accountDao.getAll();
	}

	public ResponseDTO save(Account account) {
		ResponseDTO dto = new ResponseDTO();
		String required = validateRequest(account);
		if (required.length() == 0) {
			dto = buildResponse(accountDao.save(account), CREATED);
		} else {
			dto = buildResponse(null, REQUIRED);
			dto.setTransactionStatusDescription(required + dto.getTransactionStatusDescription());
		}

		return dto;
	}

	public ResponseDTO findById(long id) {
		ResponseDTO dto = new ResponseDTO();
		if (accountDao.findById(id).isPresent()) {
			dto = buildResponse(accountDao.findById(id).get(), FOUND);
		} else {
			dto = buildResponse(null, NFOUND);
		}
		return dto;

	}

	private ResponseDTO buildResponse(Account acc, String code) {
		ResponseDTO rdto = new ResponseDTO();
		rdto.setAccount(acc);
		rdto.setTransactionStatusCode(code);
		rdto.setTransactionStatusDescription(sMap.get(code));
		return rdto;
	}

	// simple vlaidation, can still be optimized
	private String validateRequest(Account account) {
		String ret = "";
		if (account.getCustomerEmail() == null || account.getCustomerEmail().equals("")) {
			ret += "email ";
		}

		// continue other field validation

		return ret;
	}

}
