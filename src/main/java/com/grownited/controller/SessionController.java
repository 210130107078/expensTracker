package com.grownited.controller;

import java.net.PasswordAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;


//Get Post 

@Controller
public class SessionController {
	
	@Autowired
	MailService serviceMail;

	@Autowired
	UserRepository repositoryUser;
	// signup.jsp
	
	@Autowired
	PasswordEncoder encoder;

	@GetMapping(value = { "/", "signup" }) // url
	public String signup() {
		return "Signup";// jsp name
	}

	@GetMapping("login")
	public String login(String email, String password) {
		return "Login";// jsp name
	}
	
	@PostMapping("saveuser")
	public String saveuser(UserEntity userEntity) {
		
		String encPassword = encoder.encode(userEntity.getPassword());
		userEntity.setPassword(encPassword);
		 //memory 
		//bcrypt singleton -> single object -> autowired
		
		userEntity.setRole("USER");
		repositoryUser.save(userEntity);
	// send mail
	serviceMail.sendWelcomeMail(userEntity.getEmail(),userEntity.getFirstName());
	return "Login";// jsp
		
	}

	
	

	// open ForgetPassword jsp
	@GetMapping("/forgetpassword")
	public String forgetPassword() {
		return "ForgetPassword";
	}

	// submit on ForgetPassword ->
	@PostMapping("sendOtp")
	public String sendOtp() {
		return "ChangePassword";
	}

	@PostMapping("updatepassword")
	public String updatePassword() {
		return "Login";
	}

}