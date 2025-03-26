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
import com.grownited.entity.UserEntity;
import com.grownited.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	@Autowired
	AccountRepository repoAccount;
	@GetMapping("newaccount")
	public String newaccount() {
		return "NewAccount";
		
	}
	@PostMapping("saveaccount")
	public String saveaccount(AccountEntity account,HttpSession session)
	{
		UserEntity user = (UserEntity) session.getAttribute("user");
 		Integer userId = user.getUserId(); 
 		account.setUserId(userId);	
		repoAccount.save(account);
		return "redirect:/listaccount";
	}
	
	
	
	@GetMapping("listaccount")
	public String listaccount(Model model) {
		List<Object[]> accountList = repoAccount.getAll();
		
		//how to send data from controller to jsp 
		//Model 
		model.addAttribute("allAccount",accountList);
						//dataName , dataValue
		return "ListAccount";
		
	}
	
	@GetMapping("viewaccount")
	public String viewAccount(Integer accountId, Model model) {
		// ?
		System.out.println("id ===> " + accountId);
		Optional<AccountEntity> op = repoAccount.findById(accountId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			AccountEntity account = op.get();
			// send data to jsp ->
			model.addAttribute("account", account);

		}

		return "ViewAccount";
	}
	
	@GetMapping("deleteaccount")
	public String deleteAccount(Integer accountId) {
		repoAccount.deleteById(accountId);//delete from guests where guestID = :guestId
		return "redirect:/listaccount";
	}
	
	

}
