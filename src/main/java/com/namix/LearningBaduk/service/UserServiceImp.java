package com.namix.LearningBaduk.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.AlarmView;
import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BoardDao boardDao;

	@Override
	public int idOverlapCheck(String id) {
		return userDao.idOverlapCheck(id);
	}

	@Override
	public int nicknameOverlapCheck(String nickname) {
		return userDao.nicknameOverlapCheck(nickname);
	}

	@Override
	public int withdraw(String id) {
		return userDao.withdraw(id);
	}

	@Override
	public void editProfileImg(MultipartFile file, HttpServletRequest request, String userId) throws IOException {

		String imgName = file.getName();
		String imgPath = request.getServletContext().getRealPath("/profileImg");

		File uploadImg = new File(imgPath);
		if (!uploadImg.exists()) {
			uploadImg.mkdir();
		}

		imgName = UUID.randomUUID().toString();
		imgPath = imgPath + "/" + imgName;
		String imgUrl = request.getContextPath() + "/profileImg/" + imgName;

		byte[] bytes = file.getBytes();
		OutputStream out = new FileOutputStream(new File(imgPath));
		out.write(bytes);

		addUserProfileImg(imgUrl, userId);
		addProfileImg(imgName, imgUrl, userId);

	}

	@Override
	public int addUserProfileImg(String imgUrl, String userId) {
		return userDao.addUserProfileImg(imgUrl, userId);
	}

	@Override
	public int addProfileImg(String imgName, String imgUrl, String userId) {
		return userDao.addProfileImg(imgName, imgUrl, userId);
	}

	@Override
	public void deleteProfileImg(String userId) {
		userDao.deleteProfileImg(userId);
		// userDao.deleteUserProfileImg(userId);
	}

	@Override
	public UserProfileImg getProfileImg(String userId) {
		return userDao.getProfileImg(userId);
	}

	@Override
	public List<User> getUsers(Integer page, String field, String query) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		return userDao.getUsers(offset, size, field, query);
	}

	@Override
	public int getUserCount(String field, String query) {
		return userDao.getUserCount(field, query);
	}

	@Override
	public List<User> getReportUsers(int page, String field, String query) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		return userDao.getReportUsers(offset, size, field, query);
	}

	@Override
	public int getReportUserCount(String field, String query) {
		return userDao.getReportUserCount(field, query);
	}

	@Override
	public void initUserReports(List<String> chkArray) {
		for (int i = 0; i < chkArray.size(); i++) {
			String id = chkArray.get(i);
			userDao.initUserReport(id);
		}
		for (int i = 0; i < chkArray.size(); i++) {
			String id = chkArray.get(i);
			userDao.deleteUserReportList(id);
		}
	}

	@Override
	public void deleteUserProfileImg(String userId) {
		userDao.deleteUserProfileImg(userId);
	}

	@Override
	public User getUser(String userId) {
		return userDao.getUser(userId);
	}

	@Override
	public int reportUser(String reportedUser, String reportContent, String reporter) {

		int haveReported = boardDao.haveYouReported(reportedUser, reporter);
		if (haveReported >= 1) {
			return -1;
		} else {
			userDao.addUsersReport(reportedUser);
			userDao.postReportList("user", reportedUser, reportContent, reporter);
			return 1;
		}

	}

	@Override
	public List<ReportList> getUserReportList(String userId, int page) {

		int size = 10;
		int offset = 0 + (page - 1) * size;
		return userDao.getUserReportList(userId, size, offset);
	}

	@Override
	public int getUserReportsCount(String userId) {
		return userDao.getUserReportsCount(userId);
	}

	@Override
	public ReportList getReport(int id) {
		return userDao.getReport(id);
	}

	@Override
	public User getUserByNickname(String userNickname) {
		return userDao.getUserByNickname(userNickname);
	}

	@Override
	public int sendMessage(String sender, String receiver, String messageTitle, String messageContent) {
		Message message = new Message();
		message.setSender(sender);
		message.setReceiver(receiver);
		message.setMessageTitle(messageTitle);
		message.setMessageContent(messageContent);
		int result = userDao.sendMessage(message);
		if(!sender.equals(receiver)) {
			userDao.addMessageAlarm(message);
		}

		return result;
	}

	@Override
	public int getAlarmCount(String receiver) {
		return userDao.getAlarmCount(receiver);
	}

	@Override
	public List<AlarmView> getAlarms(String receiver) {
		return userDao.getAlarms(receiver);
	}

	@Override
	public int deleteAlarm(int alarmId) {
		return userDao.deleteAlarm(alarmId);
	}

	@Override
	public int deleteAllAlarm(String receiver) {
		return userDao.deleteAllAlarm(receiver);
	}

	@Override
	public int emailOverlapCheck(String email) {
		return userDao.emailOverlapCheck(email);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public User getVerifiedUser(String userId) {
		return userDao.getVerifiedUser(userId);
	}

	@Override
	public User getVerifiedUserByEmail(String email) {
		return userDao.getVerifiedUserByEmail(email);
	}

}
