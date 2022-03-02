package com.example.api.dto;

import com.example.api.entities.Account;

public class ResponseDTO {

	private Account account;
	private String transactionStatusCode;
	private String transactionStatusDescription;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTransactionStatusCode() {
		return transactionStatusCode;
	}

	public void setTransactionStatusCode(String transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}

	public String getTransactionStatusDescription() {
		return transactionStatusDescription;
	}

	public void setTransactionStatusDescription(String transactionStatusDescription) {
		this.transactionStatusDescription = transactionStatusDescription;
	}

}
