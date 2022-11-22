package com.java.shopshore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.shopshore.entities.Accounts;
import com.java.shopshore.repository.AccountRepository;
import com.java.shopshore.service.AccountService;

@Service
public class AccountServiceimpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Accounts> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Accounts loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username);
	}

	@Override
	public boolean checkLogin(Accounts accounts) {
		// TODO Auto-generated method stub
		int status = accountRepository.loginAccount(accounts.getUsername(), accounts.getPassword());
		if (status > 0) {
			return true;
		}
		return false;
	}
}
