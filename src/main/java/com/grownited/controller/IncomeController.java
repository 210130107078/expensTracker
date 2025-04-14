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
		List<Object[]> op = repoIncome.getByIncomeId(incomeId);
		
			model.addAttribute("income", op);

		

		return "ViewIncome";
	}
	
	
	@GetMapping("editincome")
 	public String editIncome(Integer incomeId,Model model) {
 		Optional<IncomeEntity> op = repoIncome.findById(incomeId);
 		if (op.isEmpty()) {
 			return "redirect:/listincome";
 		} else {
 			model.addAttribute("income",op.get());
 			return "EditIncome";
 
 		}
 	}
 	//save -> entity -> no id present -> insert 
 	//save -> entity -> id present -> not present in db -> insert 
 	//save -> entity -> id present -> present in db -> update  
 
 	@PostMapping("updateincome")
 	public String updateIncome(IncomeEntity incomeEntity) {//pcode vhreg type vid 
 		
 		System.out.println(incomeEntity.getIncomeId());//id? db? 
 
 		Optional<IncomeEntity> op = repoIncome.findById(incomeEntity.getIncomeId());
 		
 		if(op.isPresent())
 		{
 			IncomeEntity dbIncome = op.get(); //pcode vhreg type id userId 
 			dbIncome.setTitle(incomeEntity.getTitle());//code 
 			dbIncome.setStatus(incomeEntity.getStatus());
 			dbIncome.setAmount(incomeEntity.getAmount());//type 
 			dbIncome.setDescription(incomeEntity.getDescription());//type 
 			//
 			repoIncome.save(dbIncome);
 		}
 		return "redirect:/listincome";
 	}
	
	
	@GetMapping("deleteincome")
	public String deleteIncome(Integer incomeId) {
		repoIncome.deleteById(incomeId);//delete from guests where guestID = :guestId
		return "redirect:/listincome";
	}
	
	
}
