package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.AccountEntity;
import com.grownited.entity.CategoryEntity;
import com.grownited.repository.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository repoCategory;
	private Object categoryList;

	@GetMapping("newcategory")
	public String newcategory() {
		return "NewCategory";
	}
	@PostMapping("savecategory")
	public String savecategory(CategoryEntity category) {
		repoCategory.save(category);
		return "redirect:/listcategory";	
		
	}
	
	@GetMapping("listcategory")
	public String listcategory(Model model) {
		List<CategoryEntity> categoryList = repoCategory.findAll();
		
		//how to send data from controller to jsp 
		//Model 
		model.addAttribute("categoryList",categoryList);
						//dataName , dataValue
		return "ListCategory";
		
	}
}
