package com.grownited.controller.Admin;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ExpenseRepository;
import com.grownited.repository.UserRepository;

import jakarta.mail.Session;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	Cloudinary cloudinary;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@GetMapping("admindashboard")
	public String adminDashboard(Model model) {
		
		//hr mentor admin user
				//total users
				//total intersn[user] 
				//this month users 
				//total internship 
				//total application 
				
				//select count(*) from users; 
				Long totalUsers = userRepository.count();//total of users table 
				Long thismonthusers = userRepository.count();
				Long thismonthtotaltransactioncount =expenseRepository.count();
				
				
				
				
				//select * from users where role = 'USER'; 
				Integer totalInterns = userRepository.findByRole("USER").size();
			//	Integer totalAdmin = userRepository.findByRole("ADMIN").size();
				
				Long[] monthWiseInterns = new Long[]{5L, 12L, 8L, 15L, 10L, 6L, 18L, 22L, 14L, 9L, 11L, 7L};
				model.addAttribute("monthWiseInterns", monthWiseInterns);

				
				
				model.addAttribute("totalusers",totalUsers);
				model.addAttribute("thismonthtotaltransactioncount",thismonthtotaltransactioncount);
				model.addAttribute("thismonthusers",thismonthusers);
				
				
				
		return "AdminDashboard";
	}

	
	@GetMapping("adminprofile")
	public String adminprofile() {
		return "AdminProfile";
	}

	@GetMapping("updateprofile")
	public String updateprofile() {
		return "UpdateProfile";
	}
	
	@PostMapping("updateprofile")
	public String postMethodName(MultipartFile profilePic, UserEntity userEntity, HttpSession session, Model model) {
		//TODO: process POST request
		
		
		if(profilePic!=null && !profilePic.isEmpty())
		{
			try {
	 			Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
	 			//System.out.println(result);
	 			//System.out.println(result.get("url"));
	 			userEntity.setProfilePicPath(result.get("url").toString());
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
		}
		
		
		Optional<UserEntity> op = userRepository.findById(userEntity.getUserId());
		
		if(op.isPresent())
		{
			UserEntity existingUserEntity = op.get();
			
			existingUserEntity.setFirstName(userEntity.getFirstName());
			existingUserEntity.setLastName(userEntity.getLastName());
			
			existingUserEntity.setEmail(userEntity.getEmail());
			existingUserEntity.setContactNum(userEntity.getContactNum());
			existingUserEntity.setCity(userEntity.getCity());
			existingUserEntity.setGender(userEntity.getGender());
			existingUserEntity.setBornYear(userEntity.getBornYear());
			
			if(profilePic!=null && !profilePic.isEmpty())
			{
				existingUserEntity.setProfilePicPath(userEntity.getProfilePicPath());
			}
			
			userRepository.save(existingUserEntity);
			
			session.setAttribute("user", existingUserEntity);
			
			return "redirect:/adminprofile";
		}
		else {
			model.addAttribute("error", "Profile not updated");
			
			return "adminprofile";
		}
		
		
	}
	
}
