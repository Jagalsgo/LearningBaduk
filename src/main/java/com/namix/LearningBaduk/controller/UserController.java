package com.namix.LearningBaduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("editProfile")
	public String editProfile() {
		return "user.editProfile";
	}
	
	@GetMapping("findAccount")
	public String findAccout() {
		return "user.findAccount";
	}
	
	@GetMapping("signUp")
	public String signUp() {
		return "user.signUp";
	}
	
	@PostMapping("login")
	public void login(@RequestParam("username") String id, @RequestParam("userpassword") String password ,Model model) {
		
		User loginResult = service.login(id, password);
		System.out.println("AAA");
		
	}
	
}
