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
		
		List<BoardView> boards = service.getBoards(page, field, query);
		int pageCount = service.getPageCount(field, query);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);
		
		return "board.endGameBoard";
	}
	@GetMapping("freeBoard")
	public String freeBoard() {
		return "board.freeBoard";
	}
	@GetMapping("myOwnBoard")
	public String myOwnBoard() {
		return "board.myOwnBoard";
	}
	@GetMapping("myWritingBoard")
	public String myWritingBoard() {
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
