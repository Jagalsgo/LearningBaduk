package com.namix.LearningBaduk.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.service.BoardService;
import com.namix.LearningBaduk.service.CommentService;
import com.namix.LearningBaduk.service.DetailService;
import com.namix.LearningBaduk.service.UserService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;
	@Autowired
	private DetailService detailService;
	@Autowired
	private CommentService commentService;

	@GetMapping("adminBoard")
	public String adminBoard(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "f", defaultValue = "boardTitle") String field,
			@RequestParam(value = "q", defaultValue = "") String query, @RequestParam("ct") String ct, Model model) {

		// Board Category
		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);

		List<BoardView> boards = boardService.getBoards(category.getCategoryBoard(), page, field, query);
		int pageCount = boardService.getPageCount(category.getCategoryBoard(), field, query);

		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("category", category);

		return "admin.adminBoard";
	}

	@GetMapping("adminDetail")
	public String adminDetail(@RequestParam("id") int id, HttpServletRequest request, @RequestParam("ct") String ct,
			HttpServletResponse response, Model model) {

		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);

		BoardView boardView = boardService.getDetailBoard(id);
		int boardCount = boardService.getPageCount(category.getCategoryBoard());
		int detailsPage = detailService.getDetailsPage(id);

		model.addAttribute("boardView", boardView);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("detailsPage", detailsPage);
		model.addAttribute("category", category);

		// Prevent View Count Duplication Use Cookie
		Cookie[] cookies = request.getCookies();
		Cookie viewCookie = null;

		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookie" + id)) {
					viewCookie = cookies[i];
				}
			}
		}
		if (viewCookie == null) {

			Cookie newCookie = new Cookie("cookie" + id, "|" + id + "|");
			response.addCookie(newCookie);

			detailService.addHit(id);

		}

		return "admin.adminDetail";
	}

	@GetMapping("adminPages")
	public String adminPages(Model model) {

		int reportedBoardCount = boardService.getReportPageCount("boardTitle", "");
		int reportedUserCount = userService.getReportUserCount("userNickname", "");

		model.addAttribute("reportedBoardCount", reportedBoardCount);
		model.addAttribute("reportedUserCount", reportedUserCount);

		return "admin.adminPages";
	}

	@GetMapping("boardReportList")
	public String boardReportList(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "f", defaultValue = "boardTitle") String field,
			@RequestParam(value = "q", defaultValue = "") String query, Model model) {

		List<BoardView> boards = boardService.getReportBoards(page, field, query);
		int pageCount = boardService.getReportPageCount(field, query);
		
		model.addAttribute("boards", boards);
		model.addAttribute("pageCount", pageCount);

		return "admin.boardReportList";
	}

	@GetMapping("userReportList")
	public String userReportList(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "f", defaultValue = "userNickname") String field,
			@RequestParam(value = "q", defaultValue = "") String query, Model model) {

		List<User> users = userService.getReportUsers(page, field, query);
		int userCount = userService.getReportUserCount(field, query);
		
		model.addAttribute("users", users);
		model.addAttribute("pageCount", userCount);

		return "admin.userReportList";
	}

	@GetMapping("userManagement")
	public String userManagement(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "f", defaultValue = "userNickname") String field,
			@RequestParam(value = "q", defaultValue = "") String query, Model model) {

		List<User> users = userService.getUsers(page, field, query);
		int userCount = userService.getUserCount(field, query);
		
		model.addAttribute("users", users);
		model.addAttribute("pageCount", userCount);

		return "admin.userManagement";
	}

	@ResponseBody
	@DeleteMapping("deleteBoards")
	public void deleteBoards(@RequestParam("chkArray[]") List<Integer> chkArray) {
		boardService.deleteBoards(chkArray);
	}

	@ResponseBody
	@DeleteMapping("deleteComments")
	public void deleteComments(@RequestParam("boardId") Integer boardId) {
		commentService.deleteAllComment(boardId);
	}

	@ResponseBody
	@PutMapping("initBoardReports")
	public void initBoardReports(@RequestParam("chkArray[]") List<Integer> chkArray) {
		boardService.initBoardReports(chkArray);
	}

	@ResponseBody
	@PutMapping("initUserReports")
	public void initUserReports(@RequestParam("chkArray[]") List<String> chkArray) {
		userService.initUserReports(chkArray);
	}

}
