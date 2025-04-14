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
import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubcategoryRepository;

import jakarta.servlet.http.HttpSession;

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
	public String savecategory(CategoryEntity category,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
 		Integer userId = user.getUserId(); 
 		category.setUserId(userId);
		
		repoCategory.save(category);
		return "redirect:/listcategory";	
		
	}

 	
 	
	
	@GetMapping("listcategory")
	public String listcategory(Model model) {
		List<Object[]> categoryList = repoCategory.getAll();
		
		//how to send data from controller to jsp 
		//Model 
		model.addAttribute("allCategory",categoryList);
						//dataName , dataValue
		return "ListCategory";
		
	}
	
	@GetMapping("viewcategory")
	public String viewCategory(Integer categoryId, Model model) {
		// ?
		System.out.println("id ===> " + categoryId);
		List<Object[]> op = repoCategory.getByCategoryId(categoryId);
		
			model.addAttribute("category", op);

		

		return "ViewCategory";
	}
	
	@GetMapping("editcategory")
	public String editCategory(Integer categoryId,Model model) {
		Optional<CategoryEntity> op = repoCategory.findById(categoryId);
		if (op.isEmpty()) {
			return "redirect:/listcategory";
		} else {
			model.addAttribute("category",op.get());
			return "EditCategory";

		}
	}
	//save -> entity -> no id present -> insert 
	//save -> entity -> id present -> not present in db -> insert 
	//save -> entity -> id present -> present in db -> update  

	@PostMapping("updatecategory")
	public String updateCategory(CategoryEntity categoryEntity) {//pcode vhreg type vid 
		
		System.out.println(categoryEntity.getCategoryId());//id? db? 

		Optional<CategoryEntity> op = repoCategory.findById(categoryEntity.getCategoryId());
		
		if(op.isPresent())
		{
			CategoryEntity dbCategory = op.get(); //pcode vhreg type id userId 
			dbCategory.setTitle(categoryEntity.getTitle());//code 
			
			repoCategory.save(dbCategory);
		}
		return "redirect:/listcategory";
	}
	@GetMapping("deletecategory")
	public String deleteCategory(Integer categoryId) {
		repoCategory.deleteById(categoryId);//delete from guests where guestID = :guestId
		return "redirect:/listcategory";
	}
	
}
