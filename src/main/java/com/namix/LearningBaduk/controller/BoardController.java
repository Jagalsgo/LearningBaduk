package com.namix.LearningBaduk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("home")
	public String home() {
		return "board.home";
	}
	@GetMapping("endGameBoard")
	public String endGameBoard(@RequestParam(value="p", defaultValue="1") Integer page,
											@RequestParam(value="f", defaultValue="boardTitle") String field,
											@RequestParam(value="q", defaultValue="") String query, Model model) {
		
		String category = "endGameBoard";
		List<BoardView> boards = service.getBoards(category, page, field, query);
		int pageCount = service.getPageCount(category, field, query);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);
		
		return "board.endGameBoard";
	}
	@GetMapping("freeBoard")
	public String freeBoard(@RequestParam(value="p", defaultValue="1") Integer page,
			@RequestParam(value="f", defaultValue="boardTitle") String field,
			@RequestParam(value="q", defaultValue="") String query, Model model) {
		
		String category = "free";
		List<BoardView> boards = service.getBoards(category, page, field, query);
		int pageCount = service.getPageCount(category, field, query);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);
		
		return "board.freeBoard";
	}
	@GetMapping("myOwnBoard")
	public String myOwnBoard(@RequestParam(value="p", defaultValue="1") Integer page,
			@RequestParam(value="q", defaultValue="") String query, Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		
		List<BoardView> boards = service.getMyOwnBoards(page, query, userId);
		int pageCount = service.getMyOwnPageCount(query, userId);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);
		
		return "board.myOwnBoard";
	}
	@GetMapping("myWritingBoard")
	public String myWritingBoard(@RequestParam(value="p", defaultValue="1") Integer page,
											@RequestParam(value="q", defaultValue="") String query, Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		
		List<BoardView> boards = service.getMyWritingBoards(page, query, userId);
		int pageCount = service.getMyWritingPageCount(query, userId);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);
		
		return "board.myWritingBoard";
	}
	@GetMapping("noticeBoard")
	public String noticeBoard() {
		return "board.noticeBoard";
	}
	@GetMapping("openingBoard")
	public String openingBoard() {
		return "board.openingBoard";
	}
	@GetMapping("patternBoard")
	public String patternBoard() {
		return "board.patternBoard";
	}
	@GetMapping("quetionBoard")
	public String quetionBoard() {
		return "board.quetionBoard";
	}
	@GetMapping("ruleBoard")
	public String ruleBoard() {
		return "board.ruleBoard";
	}
	@GetMapping("scheduleBoard")
	public String scheduleBoard() {
		return "board.scheduleBoard";
	}

}
