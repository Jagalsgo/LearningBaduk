package com.namix.LearningBaduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@GetMapping("adminBoard")
	public String adminBoard() {
		return "admin.adminBoard";
	}

	@GetMapping("adminDetail")
	public String adminDetail() {
		return "admin.adminDetail";
	}
	
	@GetMapping("reportHistoryBoard")
	public String reportHistoryBoard() {
		return "admin.reportHistoryBoard";
	}
	
	@GetMapping("userManagement")
	public String userManagement() {
		return "admin.userManagement";
	}
	
}
