package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.VendorEntity;
import com.grownited.repository.VendorRepository;

@Controller
public class VendorController {
	
	@Autowired
	VendorRepository repoVendor;
	@GetMapping("newvendor")
	public String newvendor() {
		return "NewVendor";
	}
	@PostMapping("savevendor")
	public String savevendor(VendorEntity vendor) {
		repoVendor.save(vendor);
		return "NewVendor";		
	}

}
