package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.service.BoardService;

@Controller
@RequestMapping("/detail/")
public class DetailController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("detail")
	public String detail(@RequestParam("id") int id, @RequestParam("ctK") String categoryKor, 
								@RequestParam("ctE") String categoryEng, Model model) {
		
		BoardView boardView = service.getDetailBoard(id);
		List<Comment> comments = service.getComments(id);
		model.addAttribute("comments", comments);
		model.addAttribute("boardView", boardView);
		model.addAttribute("categoryKor", categoryKor);
		model.addAttribute("categoryEng", categoryEng);
		
		return "detail.detail";
	}
	
	@GetMapping("updateDetail")
	public String updateDetail(@RequestParam("id") int id, Model model) {
		
		BoardView boardView = service.getDetailBoard(id);
		model.addAttribute("boardView", boardView);
		
		return "detail.updateDetail";
	}
	
	@PostMapping("updateDetail")
	public void updateDetailPost(@RequestParam("id") int id, @RequestParam("updateTitle") String title, 
											@RequestParam("updateContent") String content, HttpServletResponse response) throws IOException {
		
		int updateDetailResult = 0;
		updateDetailResult = service.updateDetail(id, title, content);
		
		if(updateDetailResult == 0) {
			ScriptClass.alert(response, "글 수정 중 오류 발생");
			ScriptClass.historyBack(response);
		}else {
			ScriptClass.alertAndMove(response, "글 수정 완료", "/detail/detail?id="+id);
		}
		
	}
	
	@GetMapping("deleteDetail")
	public void deleteDetail(@RequestParam("id") int id, @RequestParam("ct") String category, HttpServletResponse response) throws IOException {
		
		int deleteDetailResult = 0;
		deleteDetailResult = service.deleteDetail(id);
		
		if(deleteDetailResult == 0) {
			ScriptClass.alert(response, "글 삭제 중 오류 발생");
			ScriptClass.historyBack(response);
		}else {
			ScriptClass.alertAndMove(response, "글 삭제 완료", "/board/"+category);
		}
		
	}
	
	@GetMapping("writeDetail")
	public String writeDetail(@RequestParam("categoryEng") String categoryEng, @RequestParam("categoryKor") String categoryKor, Model model) {
		
		model.addAttribute("categoryEng", categoryEng);
		model.addAttribute("categoryKor", categoryKor);
		
		return "detail.writeDetail";
	}
	
	@PostMapping("writeDetail")
	public void writeDetailPost(@RequestParam("writeTitle") String title, @RequestParam("writeContent") String content,
											@RequestParam("categoryEng") String category, HttpSession session, HttpServletResponse response) throws IOException {
		
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		int writeDetailResult = 0;
		writeDetailResult = service.writeDetail(category, title, content, userId);
		
		if(writeDetailResult == 0) {
			ScriptClass.alert(response, "글 작성 중 오류 발생");
			ScriptClass.historyBack(response);
		}else {
			ScriptClass.alertAndMove(response, "글 작성 완료", "/detail/detail");
		}
		
	}

}
