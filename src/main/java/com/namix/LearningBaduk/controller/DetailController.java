package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.MyBoard;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.service.BoardService;

@Controller
@RequestMapping("/detail/")
public class DetailController {

	@Autowired
	private BoardService service;

	@GetMapping("detail")
	public String detail(@RequestParam("id") int id, HttpServletRequest request,
			@RequestParam(value = "ct", required = false) String ct, HttpServletResponse response, Model model) {

		if (ct == null) {
			ct = service.getCategory(id);
		}
		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);
		BoardView boardView = service.getDetailBoard(id);
		int boardCount = service.getPageCount(category.getCategoryBoard());
		int detailsPage = service.getDetailsPage(id);

		model.addAttribute("boardView", boardView);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("detailsPage", detailsPage);
		model.addAttribute("category", category);

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

			service.addHit(id);

		}

		return "detail.detail";

	}

	@GetMapping("myOwnDetail")
	public String myOwnDetail(@RequestParam("id") int id, HttpServletResponse response, Model model,
			Principal principal) {

		String userId = principal.getName();

		MyBoard board = service.getMyDetailBoard(id);
		int boardCount = service.getMyOwnPageCount(userId);
		int detailsPage = service.getMyDetailsPage(id);

		model.addAttribute("board", board);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("detailsPage", detailsPage);

		return "detail.myOwnDetail";

	}

	@GetMapping("updateDetail")
	public String updateDetail(@RequestParam("id") int id, @RequestParam("ct") String ct, Model model) {

		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);
		BoardView boardView = service.getDetailBoard(id);
		model.addAttribute("boardView", boardView);
		model.addAttribute("category", category);

		return "detail.updateDetail";
	}

	@PostMapping("updateDetail")
	public void updateDetailPost(@RequestParam("id") int id, @RequestParam("updateTitle") String title,
			@RequestParam("updateContent") String content, @RequestParam("ct") String ct, HttpServletResponse response)
			throws IOException {

		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);
		int updateDetailResult = 0;
		updateDetailResult = service.updateDetail(id, title, content);

		if (updateDetailResult == 0) {
			ScriptClass.alert(response, "??? ?????? ??? ?????? ??????");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "??? ?????? ??????", "/detail/detail?ct=" + category.getCt() + "&id=" + id);
		}

	}

	@GetMapping("updateMyDetail")
	public String updateMyDetail(@RequestParam("id") int id, Model model) {

		MyBoard board = service.getMyDetailBoard(id);
		model.addAttribute("board", board);

		return "detail.updateMyDetail";
	}

	@PostMapping("updateMyDetail")
	public void updateMyDetailPost(@RequestParam("id") int id, @RequestParam("updateTitle") String title,
			@RequestParam("updateContent") String content, HttpServletResponse response) throws IOException {

		int updateDetailResult = 0;
		updateDetailResult = service.updateMyDetail(id, title, content);

		if (updateDetailResult == 0) {
			ScriptClass.alert(response, "??? ?????? ??? ?????? ??????");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "??? ?????? ??????", "/detail/myOwnDetail?id=" + id);
		}

	}

	@GetMapping("deleteDetail")
	public void deleteDetail(@RequestParam("id") int id, @RequestParam("ct") String ct, HttpServletResponse response)
			throws IOException {

		int deleteDetailResult = 0;
		deleteDetailResult = service.deleteDetail(id);

		if (deleteDetailResult == 0) {
			ScriptClass.alert(response, "??? ?????? ??? ?????? ??????");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "??? ?????? ??????", "/board/board?ct=" + ct);
		}

	}

	@GetMapping("deleteMyDetail")
	public void deleteMyDetail(@RequestParam("id") int id, HttpServletResponse response) throws IOException {

		int deleteDetailResult = 0;
		deleteDetailResult = service.deleteMyDetail(id);

		if (deleteDetailResult == 0) {
			ScriptClass.alert(response, "??? ?????? ??? ?????? ??????");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "??? ?????? ??????", "/board/myOwnBoard");
		}

	}

	@GetMapping("writeDetail")
	public String writeDetail(@RequestParam("writeCt") String ct, Model model) {

		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);

		model.addAttribute("category", category);

		return "detail.writeDetail";
	}

	@PostMapping("writeDetail")
	public void writeDetailPost(@RequestParam("writeTitle") String title, @RequestParam("writeContent") String content,
			@RequestParam("ct") String ct, Principal principal, HttpServletResponse response) throws IOException {

		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);
		String userId = principal.getName();
		int writeDetailResult = 0;
		writeDetailResult = service.writeDetail(category.getCategoryBoard(), title, content, userId);
		int boardId = service.getUsersLastBoardId(userId);

		if (writeDetailResult == 0) {
			ScriptClass.alert(response, "??? ?????? ??? ?????? ??????");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "??? ?????? ??????", "/detail/detail?ct=" + category.getCt() + "&id=" + boardId);
		}

	}

	@GetMapping("writeMyDetail")
	public String writeMyDetail() {
		return "detail.writeMyDetail";
	}

	@PostMapping("writeMyDetail")
	public void writeMyDetailPost(@RequestParam("writeTitle") String title,
			@RequestParam("writeContent") String content, Principal principal, HttpServletResponse response)
			throws IOException {

		String userId = principal.getName();
		int writeMyDetailResult = 0;
		writeMyDetailResult = service.writeMyDetail(title, content, userId);
		int boardId = service.getUsersLastMyBoardId(userId);

		if (writeMyDetailResult == 0) {
			ScriptClass.alert(response, "??? ?????? ??? ?????? ??????");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "??? ?????? ??????", "/detail/myOwnDetail?id=" + boardId);
		}

	}

	@ResponseBody
	@PostMapping("addLike")
	public Map<Object, Object> addLike(@RequestParam("id") int id, Principal principal) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		String userId = principal.getName();

		// ????????? ????????? ??????
		String boardUserId = service.getBoardsUser(id);
		// ?????? ????????? ????????? ??????
		int likeClicked = service.likeClicked(id, userId);
		// ?????? ???????????? ????????? ??????
		int dislikeClicked = service.DislikeClicked(id, userId);

		if (boardUserId.equals(userId)) {
			map.put("addLikeResult", -1);
			return map;
		} else if (likeClicked >= 1 || dislikeClicked >= 1) {
			map.put("addLikeResult", 0);
			return map;
		} else {

			// ???????????? ?????? ??????
			int addLikeResult = service.addLike(id, userId);
			int likeCount = service.getLikeCount(id);
			map.put("addLikeResult", addLikeResult);
			map.put("likeCount", likeCount);

			return map;
		}

	}

	@ResponseBody
	@PostMapping("addDislike")
	public Map<Object, Object> addDislike(@RequestParam("id") int id, Principal principal) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		String userId = principal.getName();

		// ????????? ????????? ??????
		String boardUserId = service.getBoardsUser(id);
		// ?????? ????????? ????????? ??????
		int likeClicked = service.likeClicked(id, userId);
		// ?????? ???????????? ????????? ??????
		int dislikeClicked = service.DislikeClicked(id, userId);

		if (boardUserId.equals(userId)) {
			map.put("addDislikeResult", -1);
			return map;
		} else if (likeClicked >= 1 || dislikeClicked >= 1) {
			map.put("addDislikeResult", 0);
			return map;
		} else {

			// ???????????? ?????? ??????
			int addDislikeResult = service.addDislike(id, userId);
			int dislikeCount = service.getDislikeCount(id);
			map.put("addDislikeResult", addDislikeResult);
			map.put("dislikeCount", dislikeCount);

			return map;
		}

	}

	@ResponseBody
	@PostMapping("postComment")
	public Map<Object, Object> postComment(@RequestParam("boardId") int boardId, @RequestParam("commentContent") String commentContent,
			Principal principal) {

		String userId = principal.getName();
		String receiver = service.getBoardsUser(boardId);

		Comment comment = service.postComment(userId, commentContent, boardId, receiver);
		BoardView bv = service.getDetailBoard(boardId);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("commentCount", bv.getCommentCount());
		
		return map;

	}

	@ResponseBody
	@PostMapping("postReComment")
	public Map<Object, Object> postReComment(@RequestParam("boardId") int boardId,
			@RequestParam("reCommentContent") String reCommentContent, @RequestParam("parentId") int parentId,
			Principal principal) {

		String userId = principal.getName();
		Comment parentComment = service.getComment(parentId);
		String receiver = parentComment.getUserId();
		
		Comment childComment = service.postReComment(userId, reCommentContent, boardId, parentId, receiver);
		int currentPage = service.getCommentCurrentPage(childComment.getCommentId(), boardId);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("receiver", receiver);
		map.put("currentPage", currentPage);
		
		return map;

	}

	@ResponseBody
	@PostMapping("deleteComment")
	public int deleteComment(@RequestParam("commentId") int commentId) {

		int deleteCommentResult = 0;
		deleteCommentResult = service.deleteComment(commentId);
		return deleteCommentResult;

	}

	@ResponseBody
	@PostMapping("getComments")
	public List<Comment> getComments(@RequestParam("boardId") int id,
			@RequestParam(value = "commentPage", defaultValue = "1") Integer page, Model model) {
		List<Comment> comments = service.getComments(id, page);
		model.addAttribute("commentPage", page);
		return comments;
	}

	@ResponseBody
	@PostMapping("getBoards")
	public List<BoardView> getBoards(@RequestParam("category") String category,
			@RequestParam(value = "boardPage", defaultValue = "1") Integer boardPage, Model model) {

		List<BoardView> boards = service.getBoards(category, boardPage);
		model.addAttribute("boardPage", boardPage);
		return boards;

	}

	@ResponseBody
	@PostMapping("getMyBoards")
	public List<MyBoard> getMyBoards(@RequestParam(value = "boardPage", defaultValue = "1") Integer boardPage,
			Model model, Principal principal) {

		String userId = principal.getName();
		List<MyBoard> boards = service.getMyOwnBoards(boardPage, "", userId);
		model.addAttribute("boardPage", boardPage);
		return boards;

	}

	@ResponseBody
	@PostMapping("reportBoard")
	public int reportBoard(@RequestParam("boardId") Integer boardId, Principal principal) {

		String userId = principal.getName();
		int result = service.reportBoard(boardId, userId);

		return result;

	}

}
