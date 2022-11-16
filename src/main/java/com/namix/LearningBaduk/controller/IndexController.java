package com.namix.LearningBaduk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.namix.LearningBaduk.service.BoardService;

@Controller
public class IndexController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String index(Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = service.getHomeBoards();

		model.addAttribute("map", map);

		return "board.home";
	}
	
}
