package com.grownited.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;

import jakarta.servlet.http.HttpSession;


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
	
	@Autowired
 	Cloudinary cloudinary;
 

	@GetMapping(value = { "/", "signup" }) // url
	public String signup() {
		return "Signup";// jsp name
	}

	@GetMapping("login")
	public String login(String email, String password) {
		return "Login";// jsp name
	}
	
	@PostMapping("saveuser")
	public String saveuser(UserEntity userEntity,MultipartFile profilePic) {
		
		System.out.println(profilePic.getOriginalFilename());// file name
 		// cloud->
 		
 //		if(profilePic.getOriginalFilename().endsWith(".jpg") || || || ) {
 //			
 //		}else {
 //			//
 //			//model 
 //			return "Signup";
 //		}
 		try {
 			Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
 			//System.out.println(result);
 			//System.out.println(result.get("url"));
 			userEntity.setProfilePicPath(result.get("url").toString());
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		
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
	
	@PostMapping("authenticate")
	public String authenticate(String email, String password,Model model,HttpSession session) {// sakira@yopmail.com sakira
		System.out.println(email);
		System.out.println(password);

		// users -> email,password
		Optional<UserEntity> op = repositoryUser.findByEmail(email);
		// select * from users where email = :email and password = :password
		if (op.isPresent()) {
			// true
			// email
			UserEntity dbUser = op.get();
			
			boolean ans = encoder.matches(password, dbUser.getPassword());

			if (ans == true) {
				session.setAttribute("user", dbUser); // session -> user set
				if (dbUser.getRole().equals("ADMIN")) {

					return "redirect:/admindashboard";
				} else if (dbUser.getRole().equals("USER")) {

					return "redirect:/userdashboard";
				} else {
					model.addAttribute("error", "Please contact Admin with Error Code #2222");
					return "Login";
				}

			}
		}
		model.addAttribute("error", "Invalid Credentials");
		return "Login";

	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";// login url
	}

	

	// open ForgetPassword jsp
	@GetMapping("/forgetpassword")
	public String forgetPassword() {
		return "ForgetPassword";
	}

	// submit on ForgetPassword ->
	@PostMapping("sendotp")
	public String sendOtp(String email, Model model) {
		// email valid
		Optional<UserEntity> op = repositoryUser.findByEmail(email);
		if (op.isEmpty()) {
			// email invalid
		//	model.addAttribute("error", "Email not found");
			return "ForgetPassword";
		} else {
			// email valid
			// send mail otp
			// opt generate
			// send mail otp
			String otp = "";
			otp = (int) (Math.random() * 1000000) + "";// 0.25875621458541

			UserEntity user = op.get();
			user.setOtp(otp);
			repositoryUser.save(user);// update otp for user
			serviceMail.sendOtpForForgetPassword(email, user.getFirstName(), otp);
			return "ChangePassword";

		}
	}

	@PostMapping("updatepassword")
	public String updatePassword(String email, String password, String otp, Model model) {
		Optional<UserEntity> op = repositoryUser.findByEmail(email);
		if (op.isEmpty()) {
			model.addAttribute("error", "Invalid Data");
			return "ChangePassword";
		} else {
			UserEntity user = op.get();
			if (user.getOtp().equals(otp)) {
				String encPwd = encoder.encode(password);
				user.setPassword(encPwd);
				user.setOtp("");
				repositoryUser.save(user);// update
			} else {

				model.addAttribute("error", "Invalid Data");
				return "ChangePassword";
			}
		}
		model.addAttribute("msg","Password updated");
		return "Login";
	}

}
