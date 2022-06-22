package com.namix.LearningBaduk.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.service.UserService;

@Controller
@RequestMapping("/popup/")
public class PopupController {

	@Autowired
	UserService userService;

	@GetMapping("userProfile")
	public String userProfile(@RequestParam("userId") String userId, Model model) {

		User user = userService.getUser(userId);
		model.addAttribute("user", user);

		return "popup.userProfile";

	}

	@GetMapping("reportUser")
	public String reportUser(@RequestParam("userId") String userId, Model model) {

		User user = userService.getUser(userId);
		model.addAttribute("user", user);

		return "popup.reportUser";
	}

	@GetMapping("userReports")
	public String userReports(@RequestParam("userId") String userId,
			@RequestParam(value = "p", defaultValue = "1") Integer page, Model model) {

		User user = userService.getUser(userId);
		List<ReportList> userReportList = userService.getUserReportList(userId, page);
		int userReportsCount = userService.getUserReportsCount(userId);

		model.addAttribute("user", user);
		model.addAttribute("reports", userReportList);
		model.addAttribute("pageCount", userReportsCount);

		return "popup.userReports";

	}

	@GetMapping("userReportDetail")
	public String userReportDetail(@RequestParam("id") int id,
			@RequestParam(value = "p", defaultValue = "1") Integer page, Model model) {

		ReportList reportList = userService.getReport(id);
		model.addAttribute("report", reportList);
		model.addAttribute("page", page);

		return "popup.userReportDetail";

	}

	@ResponseBody
	@PostMapping("reportUserPost")
	public int reportUserPost(@RequestParam("reportedUser") String reportedUser,
			@RequestParam(value = "reportContent", defaultValue = "") String reportContent, Principal principal) {

		String reporter = principal.getName();
		int result = userService.reportUser(reportedUser, reportContent, reporter);

		return result;
		
	}

	@ResponseBody
	@PostMapping("checkUserRole")
	public Map<Object, Object> checkUserRole(Principal principal) {

		Map<Object, Object> map = new HashMap<Object, Object>();

		if (principal == null) {
			map.put("userRole", "guest");
			return map;
		}

		User user = userService.getUser(principal.getName());
		String userRole = user.getUserRole();

		if (userRole.contains("ADMIN")) {
			map.put("userRole", "admin");
			return map;
		} else {
			map.put("userRole", "member");
			return map;
		}

	}

}
