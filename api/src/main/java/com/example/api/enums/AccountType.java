package com.example.api.enums;

public enum AccountType {

	Y("Y"), S("Savings"), C("Checking");

	public final String label;

	private AccountType(String accountType) {
		this.label = accountType;
	}


}
