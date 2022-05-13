package com.namix.LearningBaduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/detail/")
public class DetailController {
	
	@GetMapping("detail")
	public String detail() {
		return "detail.detail";
	}
	
	@GetMapping("updateDetail")
	public String updateDetail() {
		return "detail.updateDetail";
	}
	
	@GetMapping("writeDetail")
	public String writeDetail(@RequestParam("ct") String category, Model model) {
		
		model.addAttribute("category", category);
		
		return "detail.writeDetail";
	}

}
