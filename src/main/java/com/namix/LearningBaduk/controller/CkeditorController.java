package com.namix.LearningBaduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ckeditor/")
public class CkeditorController {

	
	@PostMapping("fileUpload")
	@ResponseBody
	public void fileUpload() {
	
	}
	
}
