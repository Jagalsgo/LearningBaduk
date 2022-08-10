package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.security.Principal;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.namix.LearningBaduk.entity.AlarmView;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.security.SecurityService;
import com.namix.LearningBaduk.service.AlarmService;
import com.namix.LearningBaduk.service.CommentService;
import com.namix.LearningBaduk.service.EmailService;
import com.namix.LearningBaduk.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private AlarmService alarmService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("myProfile")
	public String myProfile(Model model, Principal principal) {
		
		String userId = principal.getName();
		User user = userService.getUser(userId);
		
		model.addAttribute("user", user);
		
		return "user.myProfile";
	}
	
	@GetMapping("editProfile")
	public String editProfile() {
		return "user.editProfile";
	}

	@PutMapping("editProfile")
	public void editProfilePost(User user, @RequestParam(value = "profileImg", required = false) MultipartFile file,
			HttpServletResponse response, HttpServletRequest request, HttpSession session,
			@RequestParam("oldPassword") String oldPassword) throws IOException {

		String userId = user.getUserId();

		boolean passwordMatch = securityService.isOldPasswordMatch(userId, oldPassword);
		if (!passwordMatch) {
			ScriptClass.alert(response, "기존 비밀번호가 올바르지 않습니다.");
			ScriptClass.historyBack(response);
		} else {

			if (!file.isEmpty()) {
				UserProfileImg originProfileImg = userService.getProfileImg(userId);
				if (originProfileImg != null) {
					userService.deleteProfileImg(userId);
				}
				userService.editProfileImg(file, request, userId);
			}

			int initEmailAuth = securityService.editProfile(user);

			String loginPwd;
			if (user.getUserPassword() == null || user.getUserPassword().equals("")) {
				loginPwd = oldPassword;
			} else {
				loginPwd = user.getUserPassword();
			}

			if (initEmailAuth == 1) {
				session.invalidate();
				ScriptClass.alertAndMove(response, "회원 정보 수정 완료", "/board/home");
			}else {
				
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(userId, loginPwd));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				ScriptClass.alertAndMove(response, "회원 정보 수정 완료", "/board/home");
				
			}


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

		securityService.signUp(user);
		ScriptClass.alertAndMove(response, "회원가입 완료", "/user/login");

	}

	@GetMapping("login")
	public String login() {
		return "user.login";
	}

	@ResponseBody
	@DeleteMapping("withdraw")
	public Map<Object, Object> withdraw(String userId, String oldPassword, HttpSession session) throws IOException {

		Map<Object, Object> map = new HashMap<Object, Object>();

		boolean passwordMatch = securityService.isOldPasswordMatch(userId, oldPassword);
		if (!passwordMatch) {
			map.put("result", -1);
			return map;
		}

		userService.withdraw(userId);
		map.put("result", 1);
		session.invalidate();
		return map;

	}

	@ResponseBody
	@DeleteMapping("deleteProfileImg")
	public Map<Object, Object> deleteProfileImg(String userId, String oldPassword) throws IOException {

		Map<Object, Object> map = new HashMap<Object, Object>();

		boolean passwordMatch = securityService.isOldPasswordMatch(userId, oldPassword);
		if (!passwordMatch) {
			map.put("result", -1);
			return map;
		}

		UserProfileImg originProfileImg = userService.getProfileImg(userId);
		if (originProfileImg != null) {
			userService.deleteProfileImg(userId);
			userService.deleteUserProfileImg(userId);
		}

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userId, oldPassword));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		map.put("result", 1);
		return map;

	}

	@ResponseBody
	@PostMapping("idOverlapCheck")
	public Map<Object, Object> idOverlapCheck(String id) {

		int idCheckResult = 0;
		idCheckResult = userService.idOverlapCheck(id);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", idCheckResult);
		return map;

	}

	@ResponseBody
	@PostMapping("nicknameOverlapCheck")
	public Map<Object, Object> nicknameOverlapCheck(String nickname) {

		int nicknameCheckResult = 0;
		nicknameCheckResult = userService.nicknameOverlapCheck(nickname);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", nicknameCheckResult);
		return map;

	}

	@ResponseBody
	@PostMapping("emailOverlapCheck")
	public Map<Object, Object> emailOverlapCheck(String email) {

		int emailCheckResult = 0;
		emailCheckResult = userService.emailOverlapCheck(email);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("count", emailCheckResult);
		return map;

	}

	@ResponseBody
	@PostMapping("findId")
	public String findId(String findIdEmail) {

		User user = userService.getVerifiedUserByEmail(findIdEmail);
		if (user != null) {
			return user.getUserId();
		}

		return "null";
	}

	@ResponseBody
	@PostMapping("findPassword")
	public String findPassword(String findPasswordId, String findPasswordEmail) {

		User user = userService.getVerifiedUser(findPasswordId);
		if (user != null) {

			if (!user.getUserEmail().equals(findPasswordEmail)) {
				return "incorrectEmail"; // 해당 유저의 이메일이 올바르지 않은 경우
			} else {
				emailService.sendRandomPassword(findPasswordId, findPasswordEmail);
				return "sendRandomPassword"; // 임시 비밀번호 메일로 전송
			}

		}

		return "null"; // 해당 아이디의 유저가 없을 경우
	}

	@ResponseBody
	@DeleteMapping("deleteUser")
	public int deleteUser(@RequestParam("userId") String userId) {

		int deleteUserResult = 0;
		deleteUserResult = userService.withdraw(userId);
		return deleteUserResult;

	}

	@ResponseBody
	@PostMapping("getAlarmCount")
	public int getAlamCount(@RequestParam("receiver") String receiver) {

		int alarmCount = 0;
		alarmCount = alarmService.getAlarmCount(receiver);
		return alarmCount;

	}

	@ResponseBody
	@PostMapping("getAlarms")
	public List<AlarmView> getAlarms(@RequestParam("receiver") String receiver) {

		List<AlarmView> alarms = alarmService.getAlarms(receiver);
		return alarms;

	}

	@ResponseBody
	@DeleteMapping("deleteAlarm")
	public int deleteAlarm(@RequestParam("alarmId") Integer alarmId,
			@RequestParam(value = "commentId", required = false) Integer commentId,
			@RequestParam(value = "boardId", required = false) Integer boardId) {

		alarmService.deleteAlarm(alarmId);
		if (commentId != null) {
			return commentService.getCommentCurrentPage(commentId, boardId);
		} else {
			return 0;
		}

	}

	@ResponseBody
	@DeleteMapping("deleteAllAlarm")
	public void deleteAllAlarm(@RequestParam("receiver") String receiver) {
		alarmService.deleteAllAlarm(receiver);
	}

}
