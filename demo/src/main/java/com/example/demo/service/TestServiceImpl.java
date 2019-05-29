package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dataaccess.AccountDao;
import com.example.demo.model.Account;


@Component
public class TestServiceImpl implements TestService{
	@Autowired
	private AccountDao accountDao;

	private Account account;

	public void testmethod() {
		int  count = accountDao.getZandaka(account.getAccountNumber());

	}

}
