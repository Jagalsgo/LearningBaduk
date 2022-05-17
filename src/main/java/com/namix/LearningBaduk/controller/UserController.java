package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("editProfile")
	public String editProfile() {
		return "user.editProfile";
	}
	
	@GetMapping("findAccount")
	public String findAccout() {
		return "user.findAccount";
	}
	
	@GetMapping("signUp")
	public String signUp() {
		return "user.signUp";
	}
	
	@GetMapping("login")
	public String login() {
		return "user.login";
	}
	
	@PostMapping("login")
	public void loginPost(@RequestParam("userId") String userId, @RequestParam("userPassword") String userPassword,
									HttpServletResponse response, HttpSession session) throws IOException {
		
		User user = service.login(userId, userPassword);
		if(user == null) {
			ScriptClass.alert(response, "아이디나 비밀번호가 올바르지 않습니다.");
			ScriptClass.historyBack(response);
		}else {
			session.setAttribute("user", user);
			ScriptClass.alertAndMove(response, "로그인 완료", "/board/home");
		}	
		
	}
	
	@GetMapping("logout")
	public void logout(HttpSession session, HttpServletResponse response) throws IOException {
		session.invalidate();
		ScriptClass.alertAndMove(response, "로그아웃 완료", "/board/home");
	}
	
}
