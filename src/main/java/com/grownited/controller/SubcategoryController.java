package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
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
		return "redirect:/listsubcategory";	
		
	}
	
	@GetMapping("listsubcategory")
	public String listsubcategory(Model model) {
		List<SubcategoryEntity> subcategoryList = repoSubcategory.findAll();
		
		//how to send data from controller to jsp 
		//Model 
		model.addAttribute("subcategoryList",subcategoryList);
						//dataName , dataValue
		return "ListSubcategory";
		
	}
}
