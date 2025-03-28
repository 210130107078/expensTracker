package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.ExpenseEntity;
import com.grownited.entity.IncomeEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.IncomeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class IncomeController {
	
	@Autowired
	IncomeRepository repoIncome;
	
	@Autowired
	AccountRepository repoAccount;
	
	@GetMapping("newincome")
	public String newincome(Model model) {
List<AccountEntity> allAccount = repoAccount.findAll();// all state
 		
 		model.addAttribute("allAccount",allAccount);
		return "NewIncome";
		
	}
	
	@PostMapping("saveincome")
	public String saveincome(IncomeEntity income,Integer accountId,HttpSession session) {
		income.setAccountId(accountId);
		
		UserEntity user = (UserEntity) session.getAttribute("user");
 		Integer userId = user.getUserId(); 
 		income.setUserId(userId);
		
		repoIncome.save(income);
		return "redirect:/listincome";
	}
	
	@GetMapping("listincome")
	public String listincome(Model model) {
		List<Object[]> incomeList = repoIncome.getAll();
		//how to send data from controller to jsp 
				//Model 
				model.addAttribute("allIncome",incomeList);
								//dataName , dataValue
		return "ListIncome";
		
	}
	
	@GetMapping("viewincome")
	public String viewIncome(Integer incomeId, Model model) {
		// ?
		System.out.println("id ===> " + incomeId);
		Optional<IncomeEntity> op = repoIncome.findById(incomeId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			IncomeEntity income = op.get();
			// send data to jsp ->
			model.addAttribute("income", income);

		}

		return "ViewIncome";
	}
	
	@GetMapping("deleteincome")
	public String deleteIncome(Integer incomeId) {
		repoIncome.deleteById(incomeId);//delete from guests where guestID = :guestId
		return "redirect:/listincome";
	}
	
	
}
