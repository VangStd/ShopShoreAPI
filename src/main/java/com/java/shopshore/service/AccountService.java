package com.java.shopshore.service;

import java.util.List;

import com.java.shopshore.entities.Accounts;

public interface AccountService {

	List<Accounts> findAll();

	Accounts loadUserByUsername(String username);

	boolean checkLogin(Accounts accounts);
}
