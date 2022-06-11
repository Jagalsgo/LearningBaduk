package com.namix.LearningBaduk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.service.BoardService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("adminBoard")
	public String adminBoard(@RequestParam(value="p", defaultValue="1") Integer page,
										@RequestParam(value="f", defaultValue="boardTitle") String field,
										@RequestParam(value="q", defaultValue="") String query, 
										@RequestParam("ct") String ct, Model model) {
		
		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);
		
		List<BoardView> boards = boardService.getBoards(category.getCategoryBoard(), page, field, query);
		int pageCount = boardService.getPageCount(category.getCategoryBoard(), field, query);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("category", category);
		
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
