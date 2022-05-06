package com.namix.LearningBaduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

	@GetMapping("eidtProfile")
	public String editProfile() {
		return "user/editProfile";
	}
	
	@GetMapping("findAccount")
	public String findAccout() {
		return "user/findAccout";
	}
	
	@GetMapping("signUp")
	public String signUp() {
		return "user/signUp";
	}
	
}
