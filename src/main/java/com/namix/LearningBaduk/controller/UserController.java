package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

import com.namix.LearningBaduk.entity.AlarmView;
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
			HttpServletResponse response, HttpServletRequest request, @RequestParam("oldPassword") String oldPassword)
			throws IOException {

		String userId = user.getUserId();

		boolean passwordMatch = securityService.isOldPasswordMatch(userId, oldPassword);
		if (!passwordMatch) {
			ScriptClass.alert(response, "기존 비밀번호가 올바르지 않습니다.");
			ScriptClass.historyBack(response);
		}

		if (!file.isEmpty()) {
			UserProfileImg originProfileImg = service.getProfileImg(userId);
			if (originProfileImg != null) {
				service.deleteProfileImg(userId);
			}
			service.editProfileImg(file, request, userId);
		}

		securityService.editProfile(user);

		String loginPwd;
		if (user.getUserPassword() == null || user.getUserPassword().equals("")) {
			loginPwd = oldPassword;
		} else {
			loginPwd = user.getUserPassword();
		}

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userId, loginPwd));
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

	@GetMapping("login")
	public String login() {
		return "user.login";
	}

	@ResponseBody
	@PostMapping("withdraw")
	public Map<Object, Object> withdraw(String userId, String oldPassword, HttpSession session) throws IOException {

		Map<Object, Object> map = new HashMap<Object, Object>();

		boolean passwordMatch = securityService.isOldPasswordMatch(userId, oldPassword);
		if (!passwordMatch) {
			map.put("result", -1);
			return map;
		}

		service.withdraw(userId);
		map.put("result", 1);
		session.invalidate();
		return map;

	}

	@ResponseBody
	@PostMapping("deleteProfileImg")
	public Map<Object, Object> deleteProfileImg(String userId, String oldPassword) throws IOException {

		Map<Object, Object> map = new HashMap<Object, Object>();

		boolean passwordMatch = securityService.isOldPasswordMatch(userId, oldPassword);
		if (!passwordMatch) {
			map.put("result", -1);
			return map;
		}

		UserProfileImg originProfileImg = service.getProfileImg(userId);
		if (originProfileImg != null) {
			service.deleteProfileImg(userId);
			service.deleteUserProfileImg(userId);
		}

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userId, oldPassword));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		map.put("result", 1);
		return map;

	}

	@ResponseBody
	@PostMapping("idOverlapCheck")
	public Map<Object, Object> idOverlapCheck(String signUpId) {

		int idCheckResult = 0;
		idCheckResult = service.idOverlapCheck(signUpId);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", idCheckResult);
		return map;

	}

	@ResponseBody
	@PostMapping("nicknameOverlapCheck")
	public Map<Object, Object> nicknameOverlapCheck(String signUpNickname) {

		int nicknameCheckResult = 0;
		nicknameCheckResult = service.nicknameOverlapCheck(signUpNickname);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", nicknameCheckResult);
		return map;

	}

	@ResponseBody
	@PostMapping("deleteUser")
	public int deleteUser(@RequestParam("userId") String userId) {

		int deleteUserResult = 0;
		deleteUserResult = service.withdraw(userId);
		return deleteUserResult;

	}

	@ResponseBody
	@PostMapping("getAlarmCount")
	public int getAlamCount(@RequestParam("receiver") String receiver) {
		
		int alarmCount = 0;
		alarmCount = service.getAlarmCount(receiver);
		return alarmCount;
		
	}
	
	@ResponseBody
	@PostMapping("getAlarms")
	public List<AlarmView> getAlarms(@RequestParam("receiver") String receiver) {
		
		List<AlarmView> alarms = service.getAlarms(receiver);
		return alarms;	
		
	}
	
	@ResponseBody
	@PostMapping("deleteAlarm")
	public void deleteAlarm(@RequestParam("alarmId") Integer alarmId) {
		service.deleteAlarm(alarmId);
	}
	
	@ResponseBody
	@PostMapping("deleteAllAlarm")
	public void deleteAllAlarm(@RequestParam("receiver") String receiver) {
		service.deleteAllAlarm(receiver);
	}

}
