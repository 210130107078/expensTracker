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

import jakarta.servlet.http.HttpSession;

@Controller
public class SubcategoryController {
	
	@Autowired
	CategoryRepository repoCategory;

	@Autowired
	SubcategoryRepository repoSubcategory;
	
	@GetMapping("newsubcategory")
	public String newsubcategory(Model model) {
		
List<CategoryEntity> allCategory = repoCategory.findAll();// all state
 		
 		model.addAttribute("allCategory",allCategory);
 		
		return "NewSubcategory";
		
	}
	
	@PostMapping("savesubcategory")
	public String savesubcategory(SubcategoryEntity subcategory,Integer categoryId) {
		subcategory.setCategoryId(categoryId);
		
		
		
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
	
	
	
	
	@GetMapping("viewsubcategory")
	public String viewSubcategory(Integer subcategoryId, Model model) {
		// ?
		System.out.println("id ===> " + subcategoryId);
		Optional<SubcategoryEntity> op = repoSubcategory.findById(subcategoryId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			SubcategoryEntity subcategory = op.get();
			// send data to jsp ->
			model.addAttribute("allSubcategory", subcategory);

		}

		return "ViewSubcategory";
	}
	
	@GetMapping("deletesubcategory")
	public String deleteSubcategory(Integer subcategoryId) {
		repoSubcategory.deleteById(subcategoryId);//delete from guests where guestID = :guestId
		return "redirect:/listsubcategory";
	}
	
}
