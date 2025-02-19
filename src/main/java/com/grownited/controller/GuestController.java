package com.grownited.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.GuestEntity;
import com.grownited.repository.GuestRepository;

@Controller
public class GuestController {
	
	@Autowired
    GuestRepository repositoryGuest;
	
	@GetMapping("newguest")
	public String newGuest() {
		return "NewGuest";
	}

	@PostMapping("saveguest")
	public String saveGuest(GuestEntity entityGuest) {
		repositoryGuest.save(entityGuest);
		return "NewGuest";
	}		
		@GetMapping("listguest")
		public String listguest(Model model) {
			
			List<GuestEntity> guestList = repositoryGuest.findAll();// select .* from members; //500 -> MemberEntity
			
			//how to send data from controller to jsp 
			//Model 
			model.addAttribute("guestList", guestList);
							//dataName , dataValue 
			
			return "ListGuest";
	}
}