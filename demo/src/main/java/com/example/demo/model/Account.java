package com.example.demo.model;

public class Account {
	String accountNumber;
	int zandaka;

	public Account(String accountNumber,int zandaka) {
		this.accountNumber = accountNumber;
		this.zandaka = zandaka;

	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getZandaka() {
		return zandaka;
	}

	public void setZandaka(int zandaka) {
		this.zandaka = zandaka;
	}



}
