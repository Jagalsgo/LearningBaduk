package com.namix.LearningBaduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String writeDetail() {
		return "detail.writeDetail";
	}

}