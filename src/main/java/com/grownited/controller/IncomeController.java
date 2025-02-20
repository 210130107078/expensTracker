package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
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
		return "redirect:/listincome";
	}
	
	@GetMapping("listincome")
	public String listincome(Model model) {
		List<IncomeEntity> incomeList = repoIncome.findAll();
		//how to send data from controller to jsp 
				//Model 
				model.addAttribute("incomeList",incomeList);
								//dataName , dataValue
		return "ListIncome";
		
	}
	
}
