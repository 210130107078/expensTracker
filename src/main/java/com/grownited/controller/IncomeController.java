package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.IncomeEntity;
import com.grownited.repository.IncomeRepository;

@Controller
public class IncomeController {
	
	@Autowired
	IncomeRepository repoIncome;
	
	@GetMapping("newincome")
	public String newincome() {
		return "NewIncome";
		
	}
	
	@PostMapping("saveincome")
	public String saveincome(IncomeEntity income) {
		repoIncome.save(income);
		
		return "NewIncome";
	}
}
