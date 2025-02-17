package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.repository.AccountRepository;

@Controller
public class AccountController {
	@Autowired
	AccountRepository repoAccount;
	@GetMapping("newaccount")
	public String newaccount() {
		return "NewAccount";
		
	}
	@PostMapping("saveaccount")
	public String saveaccount(AccountEntity account)
	{
		repoAccount.save(account);
		return "NewAccount";
	}
	

}
