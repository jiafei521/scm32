package com.example.scm32.service;

import com.example.scm32.entity.Account;

public interface AccountService  extends BaseService<Account>{
	public Account login(Account account);

}
