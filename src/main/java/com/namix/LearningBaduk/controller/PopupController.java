package com.namix.LearningBaduk.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.MessageView;
import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.script.ScriptClass;
import com.namix.LearningBaduk.service.BoardService;
import com.namix.LearningBaduk.service.UserService;

@Controller
@RequestMapping("/popup/")
public class PopupController {

	@Autowired
	UserService userService;
	@Autowired
	BoardService boardService;

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

	@GetMapping("receivedMessage")
	public String receivedMessage(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "f", defaultValue = "messageTitle") String field,
			@RequestParam(value = "q", defaultValue = "") String query, Model model, Principal principal) {

		String receiver = principal.getName();
		List<MessageView> messages = boardService.getMessages(page, field, query, "receiver", receiver,
				"deleteByReceiver");
		int messageCount = boardService.getMessageCount(field, query, "receiver", receiver, "deleteByReceiver");

		model.addAttribute("messages", messages);
		model.addAttribute("messageCount", messageCount);

		return "popup.receivedMessage";

	}

	@GetMapping("sentMessage")
	public String sentMessage(@RequestParam(value = "p", defaultValue = "1") Integer page,
			@RequestParam(value = "f", defaultValue = "messageTitle") String field,
			@RequestParam(value = "q", defaultValue = "") String query, Model model, Principal principal) {

		String sender = principal.getName();
		List<MessageView> messages = boardService.getMessages(page, field, query, "sender", sender, "deleteBySender");
		int messageCount = boardService.getMessageCount(field, query, "sender", sender, "deleteBySender");

		model.addAttribute("messages", messages);
		model.addAttribute("messageCount", messageCount);

		return "popup.sentMessage";

	}

	@GetMapping("receivedMessageDetail")
	public String receivedMessageDetail(@RequestParam("id") int id,
			@RequestParam(value = "p", defaultValue = "1") Integer page, Model model) {

		MessageView messageView = boardService.getMessage(id);
		model.addAttribute("messageView", messageView);
		model.addAttribute("page", page);

		return "popup.receivedMessageDetail";

	}

	@GetMapping("sentMessageDetail")
	public String sentMessageDetail(@RequestParam("id") int id,
			@RequestParam(value = "p", defaultValue = "1") Integer page, Model model) {

		MessageView messageView = boardService.getMessage(id);
		model.addAttribute("messageView", messageView);
		model.addAttribute("page", page);

		return "popup.sentMessageDetail";

	}

	@GetMapping("sendMessage")
	public String sendMessage(@RequestParam(value = "userId", required = false) String userId, Model model) {

		User user = userService.getUser(userId);
		model.addAttribute("user", user);

		return "popup.sendMessage";

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
	@PostMapping("deleteReceivedMessage")
	public void deleteReceivedMessage(@RequestParam("chkArray[]") List<Integer> chkArray) {
		boardService.deleteMessage(chkArray, "deleteByReceiver");
	}

	@ResponseBody
	@PostMapping("deleteSentMessage")
	public void deleteSentMessage(@RequestParam("chkArray[]") List<Integer> chkArray) {
		boardService.deleteMessage(chkArray, "deleteBySender");
	}

	@GetMapping("deleteMessageDetail")
	public void deleteMessageDetail(@RequestParam("id") Integer id, @RequestParam("go") String go,
			HttpServletResponse response) throws IOException {

		String deleted = "";
		if (go.contains("received")) {
			deleted = "deleteByReceiver";
		} else {
			deleted = "deleteBySender";
		}

		boardService.deleteMessageDetail(id, deleted);
		ScriptClass.alertAndMove(response, "삭제 완료", "/popup/" + go);

	}

	@ResponseBody
	@PostMapping("sendMessagePost")
	public int sendMessagePost(@RequestParam("receiverNickname") String receiverNickname,
			@RequestParam("messageTitle") String messageTitle, @RequestParam("messageContent") String messageContent,
			Principal principal) {

		User user = userService.getUserByNickname(receiverNickname);
		if (user == null) {
			return -1;
		}
		String sender = principal.getName();
		String receiver = user.getUserId();
		int result = userService.sendMessage(sender, receiver, messageTitle, messageContent);

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
