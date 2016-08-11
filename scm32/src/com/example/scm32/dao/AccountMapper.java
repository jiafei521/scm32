package com.example.scm32.dao;

import com.example.scm32.entity.Account;


public interface AccountMapper extends BaseMapper<Account> {
	public Account login(Account account);

}