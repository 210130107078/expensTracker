package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.SubcategoryEntity;
import com.grownited.repository.SubcategoryRepository;

@Controller
public class SubcategoryController {

	@Autowired
	SubcategoryRepository repoSubcategory;
	
	@GetMapping("newsubcategory")
	public String newsubcategory() {
		return "NewSubcategory";
		
	}
	
	@PostMapping("savesubcategory")
	public String savesubcategory(SubcategoryEntity subcategory) {
		repoSubcategory.save(subcategory);
		return "NewSubcategory";
		
		
	}
}
