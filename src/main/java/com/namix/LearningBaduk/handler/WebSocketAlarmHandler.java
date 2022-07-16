package com.namix.LearningBaduk.handler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.AlarmMessage;

@Component
public class WebSocketAlarmHandler extends TextWebSocketHandler {

	List<WebSocketSession> sessions = new ArrayList<>();
	Map<String, WebSocketSession> userSessions = new HashMap<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
		String senderId = getId(session);
		userSessions.put(senderId, session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		// protocol : cmd, 댓글 작성자, 게시글 작성자, boardId (ex : reply, user1, user2, 12)
		String msg = message.getPayload();
		Gson gson = new Gson();
		AlarmMessage alarmMsg = gson.fromJson(msg, AlarmMessage.class);
		
		TextMessage sendMsg = new TextMessage(gson.toJson(alarmMsg));
		WebSocketSession receiverSession = userSessions.get(alarmMsg.getReceiver());
		if(receiverSession != null) {
			receiverSession.sendMessage(sendMsg);
		}

		/*
		 * if (StringUtils.isNotEmpty(msg)) { String[] strs = msg.split(","); if (strs
		 * != null && strs.length == 3) {
		 * 
		 * String cmd = strs[0];
		 * 
		 * if ("comment".equals(cmd)) { String boardWriter = strs[1]; String boardId =
		 * strs[2]; WebSocketSession boardWriterSession = userSessions.get(boardWriter);
		 * if (boardWriterSession != null) { TextMessage tmpMsg = new TextMessage(
		 * "<a href='/detail/detail?id=" + boardId + "'>내 게시글에 댓글이 달렸습니다.</a>");
		 * boardWriterSession.sendMessage(tmpMsg); }
		 * 
		 * } else if ("message".equals(cmd)) { String senderId = strs[1]; String
		 * receiver = strs[2]; WebSocketSession receiverSession =
		 * userSessions.get(receiver); if (receiverSession != null) { TextMessage tmpMsg
		 * = new TextMessage(
		 * "<a onclick=\"receivedMessage()\" class=\"\" style=\"cursor: pointer;\">>새 쪽지가 도착했습니다.</a>"
		 * ); receiverSession.sendMessage(tmpMsg); } }
		 * 
		 * } }
		 */
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	}

	private String getId(WebSocketSession session) {
		Principal principal = session.getPrincipal();

		if (principal == null) {
			return session.getId();
		} else {
			return principal.getName();
		}
	}

}
