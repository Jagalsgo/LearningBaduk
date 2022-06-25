package com.namix.LearningBaduk.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.MyBoard;
import com.namix.LearningBaduk.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("home")
	public String home(Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = service.getHomeBoards();

		model.addAttribute("map", map);
		model.addAttribute("endGame", map.get("endGame"));

		return "board.home";
	}

	@GetMapping("board")
	public String board(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "f", defaultValue = "boardTitle") String field,
			@RequestParam(value = "q", defaultValue = "") String query, @RequestParam("ct") String ct, Model model) {

		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);

		List<BoardView> boards = service.getBoards(category.getCategoryBoard(), page, field, query);
		int pageCount = service.getPageCount(category.getCategoryBoard(), field, query);

		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("category", category);

		return "board.board";
	}

	@GetMapping("myOwnBoard")
	public String myOwnBoard(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "q", defaultValue = "") String query, Model model, Principal principal) {

		String userId = principal.getName();

		List<MyBoard> boards = service.getMyOwnBoards(page, query, userId);
		int pageCount = service.getMyOwnPageCount(query, userId);

		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);

		return "board.myOwnBoard";
	}

	@GetMapping("myWritingBoard")
	public String myWritingBoard(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "q", defaultValue = "") String query, Model model, Principal principal) {

		String userId = principal.getName();

		List<BoardView> boards = service.getMyWritingBoards(page, query, userId);
		int pageCount = service.getMyWritingPageCount(query, userId);

		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);

		return "board.myWritingBoard";
	}

}
