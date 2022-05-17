package com.namix.LearningBaduk.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.service.BoardService;

@Controller
@RequestMapping("/detail/")
public class DetailController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("detail")
	public String detail() {
		return "detail.detail";
	}
	
	@GetMapping("updateDetail")
	public String updateDetail() {
		return "detail.updateDetail";
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
