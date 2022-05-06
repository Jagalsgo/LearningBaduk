package com.namix.LearningBaduk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@GetMapping("home")
	public String home() {
		return "board.home";
	}
	@GetMapping("endGameBoard")
	public String endGameBoard() {
		return "board/endGameBoard";
	}
	@GetMapping("freeBoard")
	public String freeBoard() {
		return "board/freeBoard";
	}
	@GetMapping("myOwnBoard")
	public String myOwnBoard() {
		return "board/myOwnBoard";
	}
	@GetMapping("myWritingBoard")
	public String myWritingBoard() {
		return "board/myWritingBoard";
	}
	@GetMapping("noticeBoard")
	public String noticeBoard() {
		return "board/noticeBoard";
	}
	@GetMapping("openingBoard")
	public String openingBoard() {
		return "board/openingBoard";
	}
	@GetMapping("patternBoard")
	public String patternBoard() {
		return "board/patternBoard";
	}
	@GetMapping("quetionBoard")
	public String quetionBoard() {
		return "board/quetionBoard";
	}
	@GetMapping("ruleBoard")
	public String ruleBoard() {
		return "board/ruleBoard";
	}
	@GetMapping("scheduleBoard")
	public String scheduleBoard() {
		return "board/scheduleBoard";
	}

}
