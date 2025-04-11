package com.grownited.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Cloudinary cloudinary;
	
	
	@GetMapping("home")
	public String home() {
		return "Home";
	}
	
	@GetMapping("userdashboard")
	public String userDashboard() {
		return "UserDashboard";
	}

	@GetMapping("listusers")
	public String listUser(Model model) {
		List<UserEntity> users = userRepository.findAll(); 
		model.addAttribute("users",users);
		return "ListUser";
	}
	
	@GetMapping("userprofile")
	public String userprofile() {
		return "UserProfile";
	}
	
	}
	


