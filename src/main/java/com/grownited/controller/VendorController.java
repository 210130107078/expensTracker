package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.entity.VendorEntity;
import com.grownited.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class VendorController {
	
	@Autowired
	VendorRepository repoVendor;
	@GetMapping("newvendor")
	public String newvendor() {
		return "NewVendor";
	}
	@PostMapping("savevendor")
	public String savevendor(VendorEntity vendor,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
 		Integer userId = user.getUserId(); 
 		vendor.setUserId(userId);
 		
 		repoVendor.save(vendor);
		return "redirect:/listvendor";		
	}
	@GetMapping("listvendor")
	public String listvendor(Model model) {
		List<Object[]> vendorList = repoVendor.getAll();
		//how to send data from controller to jsp 
				//Model 
				model.addAttribute("allVendor",vendorList);
								//dataName , dataValue
		return "ListVendor";
		
	}
	
	@GetMapping("viewvendor")
	public String viewVendor(Integer vendorId, Model model) {
		// ?
		System.out.println("id ===> " + vendorId);
		Optional<VendorEntity> op = repoVendor.findById(vendorId);
		if (op.isEmpty()) {
			// not found
		} else {
			// data found
			VendorEntity vendor = op.get();
			// send data to jsp ->
			model.addAttribute("vendor", vendor);

		}

		return "ViewVendor";
	}
	
	@GetMapping("deletevendor")
	public String deleteVendor(Integer vendorId) {
		repoVendor.deleteById(vendorId);//delete from guests where guestID = :guestId
		return "redirect:/listvendor";
	}
	
	
}
