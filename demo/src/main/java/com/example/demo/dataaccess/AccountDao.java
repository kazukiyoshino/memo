package com.example.demo.dataaccess;

import com.example.demo.model.Account;

public interface AccountDao {
	int getZandaka(String accountNumber);
	void updateZandaka(Account account);
}
