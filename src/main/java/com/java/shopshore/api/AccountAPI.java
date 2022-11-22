package com.java.shopshore.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.shopshore.entities.Accounts;
import com.java.shopshore.entities.JwtService;
import com.java.shopshore.service.AccountService;

@RestController
public class AccountAPI {

	@Autowired
	private AccountService accountService;

	@Autowired
	private JwtService jwtService;

	@GetMapping("/api/account/")
	public ResponseEntity<List<Accounts>> getAllAccount() {
		return new ResponseEntity<List<Accounts>>(accountService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/api/login")
	public ResponseEntity<String> checkLogin(HttpServletRequest request, @RequestBody Accounts accounts) {
		String result = "";
		HttpStatus httpStatus = null;
		try {
			if (accountService.checkLogin(accounts)) {
				result = jwtService.generateTokenLogin(accounts.getUsername());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong userId and password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception ex) {
			result = ex.toString();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}
}
