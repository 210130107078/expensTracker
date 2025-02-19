package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ExpenseEntity;
import com.grownited.repository.ExpenseRepository;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseRepository repoExpense;
	
	@GetMapping("newexpense")
	public String newexpense() {
		return "NewExpense";
	}
	@PostMapping("saveexpense")
	public String saveexpense(ExpenseEntity expense) {
		repoExpense.save(expense);
		return "NewExpense";
		
	}
	}
