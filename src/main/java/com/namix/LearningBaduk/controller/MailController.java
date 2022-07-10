package com.namix.LearningBaduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.namix.LearningBaduk.service.EmailService;

@Controller
@RequestMapping("/mail/")
public class MailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("confirmEmail")
	public String cofirmEmail(String email, String authToken, Integer emailTokenId, String userId, Model model) {
		int result = emailService.confirmEmail(email, authToken, emailTokenId, userId);
		model.addAttribute("state", result);
		return "mail/emailConfirmResult";
	}
	
}
