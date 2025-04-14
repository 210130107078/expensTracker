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
import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.AccountRepository;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.SubcategoryRepository;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

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
	public String saveexpense(ExpenseEntity expense,Integer accountId,Integer vendorId,Integer categoryId,Integer subcategoryId,HttpSession session) {
		expense.setAccountId(accountId);
		expense.setVendorId(vendorId);
		expense.setCategoryId(categoryId);
		expense.setSubcategoryId(categoryId);
		
		UserEntity user = (UserEntity) session.getAttribute("user");
 		Integer userId = user.getUserId(); 
 		expense.setUserId(userId);
		
		repoExpense.save(expense);
		
		return "redirect:/listexpense";
		
	}

 	
	
	@GetMapping("listexpense")
	public String listexpense(Model model) {
		List<Object[]> expenseList = repoExpense.getAll();
		//how to send data from controller to jsp 
				//Model 
				model.addAttribute("allExpense",expenseList);
								//dataName , dataValue
		return "ListExpense";
		
	}
	
	@GetMapping("viewexpense")
	public String viewExpense(Integer expenseId, Model model) {
		// ?
		System.out.println("id ===> " + expenseId);
		List<Object[]> op = repoExpense.getByExpenseId(expenseId);
		
			model.addAttribute("expense", op);

		

		return "ViewExpense";
	}
	
	
	
	@GetMapping("editexpense")
 	public String editExpense(Integer expenseId,Model model) {
 		Optional<ExpenseEntity> op = repoExpense.findById(expenseId);
 		if (op.isEmpty()) {
 			return "redirect:/listexpense";
 		} else {
 			model.addAttribute("expense",op.get());
 			return "EditExpense";
 
 		}
 	}
 	//save -> entity -> no id present -> insert 
 	//save -> entity -> id present -> not present in db -> insert 
 	//save -> entity -> id present -> present in db -> update  
 
 	@PostMapping("updateexpense")
 	public String updateExpense(ExpenseEntity expenseEntity) {//pcode vhreg type vid 
 		
 		System.out.println(expenseEntity.getExpenseId());//id? db? 
 
 		Optional<ExpenseEntity> op = repoExpense.findById(expenseEntity.getExpenseId());
 		
 		if(op.isPresent())
 		{
 			ExpenseEntity dbExpense = op.get(); //pcode vhreg type id userId 
 			dbExpense.setTitle(expenseEntity.getTitle());//code 
 			dbExpense.setStatus(expenseEntity.getStatus());
 			dbExpense.setAmount(expenseEntity.getAmount());//type 
 			dbExpense.setDescription(expenseEntity.getDescription());//type 
 			//
 			repoExpense.save(dbExpense);
 		}
 		return "redirect:/listexpense";
 	}
	
	@GetMapping("deleteexpense")
	public String deleteExpense(Integer expenseId) {
		repoExpense.deleteById(expenseId);//delete from guests where guestID = :guestId
		return "redirect:/listexpense";
	}
	
}
