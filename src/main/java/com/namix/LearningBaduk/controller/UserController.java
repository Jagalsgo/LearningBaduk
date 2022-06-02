package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("editProfile")
	public void editProfilePost(@RequestParam("editProfilePassword") String password, @RequestParam("editProfileNickname") String nickname,
										@RequestParam("editProfileEmail") String email, @RequestParam("editProfileProfileImg") String profileImg,
										@RequestParam("editProfileId") String id,
										HttpServletResponse response, HttpSession session) throws IOException {
		
		User user = (User) session.getAttribute("user");
		
		if(password == "") {
			password = user.getUserPassword();
		}
		if(nickname == "") {
			nickname = user.getUserNickname();
		}
		if(email == "") {
			email = user.getUserEmail();
		}
		if(profileImg == "") {
			profileImg = user.getUserProfileImg();
		}
		
		int editProfileResult = service.editProfile(password, nickname, email, profileImg, id);
		if(editProfileResult == 0) {
			ScriptClass.alert(response, "오류 발생");
			ScriptClass.historyBack(response);
		}else {
			ScriptClass.alertAndMove(response, "회원 정보 수정 완료", "/board/home");
		}	
		
	}
	
	@GetMapping("findAccount")
	public String findAccout() {
		return "user.findAccount";
	}
	
	@GetMapping("signUp")
	public String signUp() {
		return "user.signUp";
	}
	
	@PostMapping("signUp")
	public void signUpPost(@RequestParam("signUpId") String signUpId, @RequestParam("signUpPassword") String signUpPassword,
									@RequestParam("signUpNickname") String signUpNickname, @RequestParam("signUpEmail") String signUpEmail,
									HttpServletResponse response) throws IOException {
		
		int signUpResult = 0;
		signUpResult = service.signUp(signUpId, signUpPassword, signUpNickname, signUpEmail);
		if(signUpResult == 0) {
			ScriptClass.alert(response, "오류 발생");
			ScriptClass.historyBack(response);
		}else {
			ScriptClass.alertAndMove(response, "회원가입 완료", "/user/login");
		}	
		
	}
	
	@GetMapping("withdraw")
	public void withdraw(HttpSession session, HttpServletResponse response) throws IOException {
		
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		
		int withdrawResult = 0;
		withdrawResult = service.withdraw(userId);
		if(withdrawResult == 0) {
			ScriptClass.alert(response, "오류 발생");
			ScriptClass.historyBack(response);
		}else {
			session.invalidate();
			ScriptClass.alertAndMove(response, "회원 탈퇴 완료", "/board/home");
		}	
		
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
	
	@ResponseBody
	@PostMapping("idOverlapCheck")
	public Map<Object, Object> idOverlapCheck(String signUpId){
		
		int idCheckResult = 0;
		idCheckResult = service.idOverlapCheck(signUpId);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", idCheckResult);
		return map;
		
	}
	
	@ResponseBody
	@PostMapping("nicknameOverlapCheck")
	public Map<Object, Object> nicknameOverlapCheck(String signUpNickname){
		
		int nicknameCheckResult = 0;
		nicknameCheckResult = service.nicknameOverlapCheck(signUpNickname);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", nicknameCheckResult);
		return map;
		
	}
	
}
