package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.security.SecurityService;
import com.namix.LearningBaduk.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("editProfile")
	public String editProfile() {
		return "user.editProfile";
	}
	
	@PostMapping("editProfile")
	public void editProfilePost(User user, @RequestParam(value = "profileImg", required = false) MultipartFile file,
										HttpServletResponse response, HttpServletRequest request, 
										@RequestParam("oldPassword") String oldPassword) throws IOException {
		
		String userId = user.getUserId();
		
		if(!file.isEmpty()) {
			UserProfileImg originProfileImg = service.getProfileImg(userId);
			if(originProfileImg != null) {
				service.deleteProfileImg(userId);
			}
			service.editProfileImg(file, request, userId);
		}
		
		boolean passwordMatch = securityService.isOldPasswordMatch(userId, oldPassword);
		if(!passwordMatch) {
			ScriptClass.alert(response, "기존 비밀번호가 올바르지 않습니다.");
			ScriptClass.historyBack(response);
		}
		
		securityService.editProfile(user);
		
		String loginPwd;
		if(user.getUserPassword() == null || user.getUserPassword().equals("")) {
			loginPwd = oldPassword;
		}else {
			loginPwd = user.getUserPassword();
		}
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, loginPwd));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		ScriptClass.alertAndMove(response, "회원 정보 수정 완료", "/board/home");
		
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
	public void signUpPost(User user, HttpServletResponse response) throws IOException {
		
		securityService.signUp(user);
		ScriptClass.alertAndMove(response, "회원가입 완료", "/user/login");
		
	}
	
	@GetMapping("withdraw")
	public void withdraw(Principal principal, HttpServletResponse response, HttpSession session) throws IOException {
		
		String userId = principal.getName();
		
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
	
	@GetMapping("deleteProfile")
	public void deleteProfile(Principal principal, HttpServletResponse response) throws IOException {
		
		String userId = principal.getName();
		
		UserProfileImg originProfileImg = service.getProfileImg(userId);
		if(originProfileImg != null) {
			service.deleteProfileImg(userId);
			service.deleteUserProfileImg(userId);
		}
		ScriptClass.alertAndMove(response, "프로필 사진 삭제 완료", "/user/editProfile");
		
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
