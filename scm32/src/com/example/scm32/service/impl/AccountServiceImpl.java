package com.example.scm32.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scm32.dao.AccountMapper;
import com.example.scm32.entity.Account;
import com.example.scm32.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{
	
	@Autowired
	private AccountMapper accountMapper;
	
	@SuppressWarnings("unused")
	@PostConstruct//在构造方法后，初化前执行
	private void initBase(){
		super.baseMapper = accountMapper;
	}
	
	
	public Account login(Account account) {
		
		return accountMapper.login(account);
	}

	

}
