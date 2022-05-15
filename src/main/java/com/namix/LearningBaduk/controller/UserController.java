package com.namix.LearningBaduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.namix.LearningBaduk.service.SecurityUserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private SecurityUserService service;
	
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
	
	@GetMapping("login")
	public String login() {
		return "user.login";
	}
	
}
