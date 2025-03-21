package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ExpenseEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.VendorRepository;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseRepository repoExpense;
	
	@Autowired
	AccountRepository repoAccount;
	
	@Autowired
	VendorRepository repoVendor;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	SubcategoryRepository repoSubcategory;
	
	
	@GetMapping("newexpense")
	public String newexpense(Model model) {
List<AccountEntity> allAccount = repoAccount.findAll();// all state
 		
 		model.addAttribute("allAccount",allAccount);
 		
List<VendorEntity> allVendor = repoVendor.findAll();// all state
 		
 		model.addAttribute("allVendor",allVendor);

List<CategoryEntity> allCategory = repoCategory.findAll();// all state
 		
 		model.addAttribute("allCategory",allCategory);
 		
List<SubcategoryEntity> allSubcategory = repoSubcategory.findAll();// all state
 		
 		model.addAttribute("allSubcategory",allSubcategory);



		
		return "NewExpense";
	}
	@PostMapping("saveexpense")
	public String saveexpense(ExpenseEntity expense,Integer accountId,Integer vendorId,Integer categoryId,Integer subcategoryId) {
		expense.setAccountId(accountId);
		expense.setVendorId(vendorId);
		expense.setCategoryId(categoryId);
		expense.setSubcategoryId(categoryId);
		
		
		repoExpense.save(expense);
		
		return "redirect:/listexpense";
		
	}

 	
	
	@GetMapping("listexpense")
	public String listexpense(Model model) {
		List<ExpenseEntity> expenseList = repoExpense.findAll();
		//how to send data from controller to jsp 
				//Model 
				model.addAttribute("expenselist",expenseList);
								//dataName , dataValue
		return "ListExpense";
		
	}
	
	@GetMapping("viewexpense")
	public String viewExpense(Integer expenseId, Model model) {
		// ?
		System.out.println("id ===> " + expenseId);
		Optional<ExpenseEntity> op = repoExpense.findById(expenseId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			ExpenseEntity expense = op.get();
			// send data to jsp ->
			model.addAttribute("expense", expense);

		}

		return "ViewExpense";
	}
	
	@GetMapping("deleteexpense")
	public String deleteExpense(Integer expenseId) {
		repoExpense.deleteById(expenseId);//delete from guests where guestID = :guestId
		return "redirect:/listexpense";
	}
	
}
