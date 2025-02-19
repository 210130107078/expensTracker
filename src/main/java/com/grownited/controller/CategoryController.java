package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.repository.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository repoCategory;

	@GetMapping("newcategory")
	public String newcategory() {
		return "NewCategory";
	}
	@PostMapping("savecategory")
	public String savecategory(CategoryEntity category) {
		repoCategory.save(category);
		return "NewCategory";
		
		
	}
}
