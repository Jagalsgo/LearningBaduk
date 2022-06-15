package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserDao userDao;
	
	@GetMapping("editProfile")
	public String editProfile() {
		return "user.editProfile";
	}
	
	@PostMapping("editProfile")
	public void editProfilePost(@RequestParam("editProfilePassword") String password, @RequestParam("editProfileNickname") String nickname,
										@RequestParam("editProfileEmail") String email, @RequestParam("editProfileId") String id,
										@RequestParam("profileImg") MultipartFile file, UserProfileImg img,
										HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException {
		
		
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		
		if(password == "" || password.isBlank()) {
			password = user.getUserPassword();
		}
		if(nickname == "" || nickname.isBlank()) {
			nickname = user.getUserNickname();
		}
		if(email == "" || email.isBlank()) {
			email = user.getUserEmail();
		}
		
		if(!file.isEmpty()) {
			UserProfileImg originProfileImg = service.getProfileImg(userId);
			if(originProfileImg != null) {
				service.deleteProfileImg(userId);
			}
			service.editProfileImg(file, request, userId);
			UserProfileImg newProfileImg = service.getProfileImg(userId);
			session.setAttribute("profileImg", newProfileImg);
		}
		
		int editProfileResult = service.editProfile(password, nickname, email, id);
		
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
	public void signUpPost(User user, HttpServletResponse response) throws IOException {
		
		String rawPassword = user.getUserPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setUserPassword(encPassword	);
		
		userDao.signUp(user);
		
		/*
		 * UserVo userVo = new UserVo(); userVo.setUserId(signUpId);
		 * userVo.setUserPassword(signUpPassword);
		 * userVo.setUserNickname(signUpNickname); userVo.setUserEmail(signUpEmail);
		 * securityService.signUp(userVo);
		 */
		ScriptClass.alertAndMove(response, "회원가입 완료", "/user/login");
		
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
	
	/*
	 * @PostMapping("login") public void loginPost(@RequestParam("userId") String
	 * userId, @RequestParam("userPassword") String userPassword,
	 * HttpServletResponse response, HttpSession session) throws IOException {
	 * 
	 * System.out.println("로그인 post 컨트롤러"); // UserVo userVo =
	 * userService.loadUserByUsername(userId); UserProfileImg profileImg =
	 * service.getProfileImg(userId);
	 * 
	 * // session.setAttribute("user", userVo); session.setAttribute("profileImg",
	 * profileImg); ScriptClass.alertAndMove(response, "로그인 완료", "/board/home");
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping("logout") public void logout(HttpSession session,
	 * HttpServletResponse response) throws IOException { session.invalidate();
	 * ScriptClass.alertAndMove(response, "로그아웃 완료", "/board/home"); }
	 */
	
	@GetMapping("deleteProfile")
	public void deleteProfile(HttpSession session, HttpServletResponse response) throws IOException {
		
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		
		UserProfileImg originProfileImg = service.getProfileImg(userId);
		if(originProfileImg != null) {
			service.deleteProfileImg(userId);
			session.removeAttribute("profileImg");
		}
		ScriptClass.alertAndMove(response, "프로필 사진 삭제 완료", "/user/editProfile");
		
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("info")
	@ResponseBody
	public String info() {
		return "info";
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
