package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
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
		return "redirect:/listexpense";
		
	}
	
	@GetMapping("listexpense")
	public String listexpense(Model model) {
		List<ExpenseEntity> expenseList = repoExpense.findAll();
		//how to send data from controller to jsp 
				//Model 
				model.addAttribute("expenseList",expenseList);
								//dataName , dataValue
		return "ListExpense";
		
	}
	
}
