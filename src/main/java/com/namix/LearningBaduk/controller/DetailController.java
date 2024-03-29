package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;
import com.namix.LearningBaduk.entity.MyBoard;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.service.BoardService;
import com.namix.LearningBaduk.service.CommentService;
import com.namix.LearningBaduk.service.DetailService;

@Controller
@RequestMapping("/detail/")
public class DetailController {

	@Autowired
	private DetailService detailService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private CommentService commentService;

	@GetMapping("detail")
	public String detail(@RequestParam("id") int id, HttpServletRequest request,
			@RequestParam(value = "ct", required = false) String ct, HttpServletResponse response, Model model) {

		if (ct == null) {
			ct = boardService.getCategory(id);
		}
		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);
		BoardView boardView = boardService.getDetailBoard(id);
		int boardCount = boardService.getPageCount(category.getCategoryBoard());

		model.addAttribute("boardView", boardView);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("category", category);

		// Prevent View Count Duplication Use Cookie
		detailService.checkCookieBeforeAddHit(request, response, id);

		return "detail.detail";

	}

	@GetMapping("myOwnDetail")
	public String myOwnDetail(@RequestParam("id") int id, HttpServletResponse response, Model model,
			Principal principal, HttpServletRequest request) throws IOException {

		// Prevent URL Approach
		ScriptClass.preventUrlApproach(request, response);

		String userId = principal.getName();
		MyBoard board = boardService.getMyDetailBoard(id);
		int boardCount = boardService.getMyOwnPageCount(userId);

		model.addAttribute("board", board);
		model.addAttribute("boardCount", boardCount);

		return "detail.myOwnDetail";

	}

	@GetMapping("updateDetail")
	public String updateDetail(@RequestParam("id") int id, @RequestParam("ct") String ct, Model model,
			HttpServletResponse response, HttpServletRequest request) throws IOException {

		// Prevent URL Approach
		ScriptClass.preventUrlApproach(request, response);

		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);
		BoardView boardView = boardService.getDetailBoard(id);

		model.addAttribute("boardView", boardView);
		model.addAttribute("category", category);

		return "detail.updateDetail";
	}

	@PutMapping("updateDetail")
	public void updateDetail(@RequestParam("id") int id, @RequestParam("updateTitle") String title,
			@RequestParam("updateContent") String content, @RequestParam("ct") String ct, HttpServletResponse response)
			throws IOException {

		com.namix.LearningBaduk.entity.Category category = new com.namix.LearningBaduk.entity.Category(ct);
		int updateDetailResult = 0;
		updateDetailResult = detailService.updateDetail(id, title, content);

		if (updateDetailResult == 0) {
			ScriptClass.alert(response, "글 수정 중 오류 발생");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "글 수정 완료", "/detail/detail?ct=" + category.getCt() + "&id=" + id);
		}

	}

	@GetMapping("updateMyDetail")
	public String updateMyDetail(@RequestParam("id") int id, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// Prevent URL Approach
		ScriptClass.preventUrlApproach(request, response);

		MyBoard board = boardService.getMyDetailBoard(id);

		model.addAttribute("board", board);

		return "detail.updateMyDetail";
	}

	@PutMapping("updateMyDetail")
	public void updateMyDetail(@RequestParam("id") int id, @RequestParam("updateTitle") String title,
			@RequestParam("updateContent") String content, HttpServletResponse response) throws IOException {

		int updateDetailResult = 0;
		updateDetailResult = detailService.updateMyDetail(id, title, content);

		if (updateDetailResult == 0) {
			ScriptClass.alert(response, "글 수정 중 오류 발생");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "글 수정 완료", "/detail/myOwnDetail?id=" + id);
		}

	}

	@DeleteMapping("deleteDetail")
	public void deleteDetail(@RequestParam("id") int id, @RequestParam("ct") String ct, HttpServletResponse response)
			throws IOException {

		int deleteDetailResult = 0;
		deleteDetailResult = detailService.deleteDetail(id);

		if (deleteDetailResult == 0) {
			ScriptClass.alert(response, "글 삭제 중 오류 발생");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "글 삭제 완료", "/board/board?ct=" + ct);
		}

	}

	@DeleteMapping("deleteMyDetail")
	public void deleteMyDetail(@RequestParam("id") int id, HttpServletResponse response) throws IOException {

		int deleteDetailResult = 0;
		deleteDetailResult = detailService.deleteMyDetail(id);

		if (deleteDetailResult == 0) {
			ScriptClass.alert(response, "글 삭제 중 오류 발생");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "글 삭제 완료", "/board/myOwnBoard");
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
		writeDetailResult = detailService.writeDetail(category.getCategoryBoard(), title, content, userId);
		int boardId = boardService.getUsersLastBoardId(userId);

		if (writeDetailResult == 0) {
			ScriptClass.alert(response, "글 작성 중 오류 발생");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "글 작성 완료", "/detail/detail?ct=" + category.getCt() + "&id=" + boardId);
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
		writeMyDetailResult = detailService.writeMyDetail(title, content, userId);
		int boardId = boardService.getUsersLastMyBoardId(userId);

		if (writeMyDetailResult == 0) {
			ScriptClass.alert(response, "글 작성 중 오류 발생");
			ScriptClass.historyBack(response);
		} else {
			ScriptClass.alertAndMove(response, "글 작성 완료", "/detail/myOwnDetail?id=" + boardId);
		}

	}

	@ResponseBody
	@PostMapping("addLike")
	public Map<Object, Object> addLike(@RequestParam("id") int id, Principal principal) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		String userId = principal.getName();

		// If it is the author himself
		String boardUserId = boardService.getBoardsUser(id);
		// If you already liked
		int likeClicked = detailService.isLikeClicked(id, userId);
		// If you already disliked
		int dislikeClicked = detailService.isDislikeClicked(id, userId);

		if (boardUserId.equals(userId)) {
			map.put("addLikeResult", -1);
			return map;
		} else if (likeClicked >= 1 || dislikeClicked >= 1) {
			map.put("addLikeResult", 0);
			return map;
		} else {
			// If you did nothing
			int addLikeResult = detailService.addLike(id, userId);
			int likeCount = detailService.getLikeCount(id);

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

		// If it is the author himself
		String boardUserId = boardService.getBoardsUser(id);
		// If you already liked
		int likeClicked = detailService.isLikeClicked(id, userId);
		// If you already disliked
		int dislikeClicked = detailService.isDislikeClicked(id, userId);

		if (boardUserId.equals(userId)) {
			map.put("addDislikeResult", -1);
			return map;
		} else if (likeClicked >= 1 || dislikeClicked >= 1) {
			map.put("addDislikeResult", 0);
			return map;
		} else {

			// If you did nothing
			int addDislikeResult = detailService.addDislike(id, userId);
			int dislikeCount = detailService.getDislikeCount(id);
			map.put("addDislikeResult", addDislikeResult);
			map.put("dislikeCount", dislikeCount);

			return map;
		}

	}

	@ResponseBody
	@PostMapping("postComment")
	public Map<Object, Object> postComment(@RequestParam("boardId") int boardId,
			@RequestParam("commentContent") String commentContent, Principal principal) {

		String userId = principal.getName();
		String receiver = boardService.getBoardsUser(boardId);

		commentService.postComment(userId, commentContent, boardId, receiver);
		BoardView bv = boardService.getDetailBoard(boardId);

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
		Comment parentComment = commentService.getComment(parentId);
		String receiver = parentComment.getUserId();

		Comment childComment = commentService.postReComment(userId, reCommentContent, boardId, parentId, receiver);
		int currentPage = commentService.getCommentCurrentPage(childComment.getCommentId(), boardId);

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("receiver", receiver);
		map.put("currentPage", currentPage);

		return map;

	}

	@ResponseBody
	@DeleteMapping("deleteComment")
	public int deleteComment(@RequestParam("commentId") int commentId) {

		int deleteCommentResult = 0;
		deleteCommentResult = commentService.deleteComment(commentId);
		return deleteCommentResult;

	}

	@ResponseBody
	@GetMapping("getComments")
	public Map<Object, Object> getComments(@RequestParam("boardId") int id,
			@RequestParam(value = "commentPage", defaultValue = "1") Integer page, Model model) {

		List<CommentView> comments = commentService.getComments(id, page);
		model.addAttribute("commentPage", page);

		BoardView bv = boardService.getDetailBoard(id);

		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("commentCount", bv.getCommentCount());
		map.put("comments", comments);

		return map;
	}

	@ResponseBody
	@GetMapping("getBoards")
	public List<BoardView> getBoards(@RequestParam("category") String category,
			@RequestParam(value = "boardPage", defaultValue = "1") Integer boardPage, Model model) {

		List<BoardView> boards = boardService.getBoards(category, boardPage);
		model.addAttribute("boardPage", boardPage);
		return boards;

	}

	@ResponseBody
	@GetMapping("getMyBoards")
	public List<MyBoard> getMyBoards(@RequestParam(value = "boardPage", defaultValue = "1") Integer boardPage,
			Model model, Principal principal) {

		String userId = principal.getName();
		List<MyBoard> boards = boardService.getMyOwnBoards(boardPage, "", userId);
		model.addAttribute("boardPage", boardPage);
		return boards;

	}

	@ResponseBody
	@GetMapping("getDetailsPage")
	public int getDetailsPage(@RequestParam("boardId") Integer boardId, @RequestParam("category") String category) {

		int detailsPage = detailService.getDetailsPage(boardId, category);
		return detailsPage;

	}

	@ResponseBody
	@GetMapping("getMyDetailsPage")
	public int getMyDetailsPage(@RequestParam("boardId") Integer boardId, Principal principal) {

		String userId = principal.getName();
		int detailsPage = detailService.getMyDetailsPage(boardId, userId);
		return detailsPage;

	}

	@ResponseBody
	@PostMapping("reportBoard")
	public int reportBoard(@RequestParam("boardId") Integer boardId, Principal principal) {

		String userId = principal.getName();
		int result = boardService.reportBoard(boardId, userId);

		return result;

	}

}
