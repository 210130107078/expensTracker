package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CategoryEntity;
import com.grownited.entity.SubcategoryEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubcategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	SubcategoryRepository repoSubcategory;
	
	
	@GetMapping("newcategory")
	public String newcategory(Model model) {
		// select * from subcategory;
		List<SubcategoryEntity> allSubcategory = repoSubcategory.findAll();//all subcategory
		model.addAttribute("allSubcategory", allSubcategory);
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
	
	@GetMapping("viewcategory")
	public String viewCategory(Integer categoryId, Model model) {
		// ?
		System.out.println("id ===> " + categoryId);
		Optional<CategoryEntity> op = repoCategory.findById(categoryId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			CategoryEntity category = op.get();
			// send data to jsp ->
			model.addAttribute("category", category);

		}

		return "ViewCategory";
	}
	
	@GetMapping("deletecategory")
	public String deleteCategory(Integer categoryId) {
		repoCategory.deleteById(categoryId);//delete from guests where guestID = :guestId
		return "redirect:/listcategory";
	}
	
}
