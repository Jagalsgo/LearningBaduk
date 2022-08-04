package com.namix.LearningBaduk.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.AlarmDao;
import com.namix.LearningBaduk.dao.CommentDao;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDao commentDao;
	@Autowired
	AlarmDao alarmDao;
	
	@Override
	public List<CommentView> getComments(int id) {
		return getComments(id, 1);
	}

	@Override
	public List<CommentView> getComments(int id, int page) {

		int size = 10;
		int offset = 0 + (page - 1) * size;

		List<CommentView> comments = commentDao.getComments(id, size, offset);

		for (int i = 0; i < comments.size(); i++) {

			Comment comment = comments.get(i);
			String oldCommentDateStr = comment.getCommentDate();
			SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			Date oldCommentDate = new Date();
			int compare = 1;

			try {
				oldCommentDate = parseFormat.parse(oldCommentDateStr);
			} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			}

			Calendar now = Calendar.getInstance();
			Calendar oldCommentDateCal = Calendar.getInstance();
			oldCommentDateCal.setTime(oldCommentDate);

			int yearDif = now.get(Calendar.YEAR) - oldCommentDateCal.get(Calendar.YEAR);
			int monthDif = now.get(Calendar.MONTH) - oldCommentDateCal.get(Calendar.MONTH);
			int dayDif = now.get(Calendar.DATE) - oldCommentDateCal.get(Calendar.DATE);

			if (yearDif == 0 && monthDif == 0 && dayDif == 0) {
				compare = 0;
			}

			if (compare >= 1) {
				String newCommentDateStr = dateFormat.format(oldCommentDate);
				comment.setCommentDate(newCommentDateStr);
			} else {
				String newCommentDateStr = timeFormat.format(oldCommentDate);
				comment.setCommentDate(newCommentDateStr);
			}

		}

		return comments;
	}

	@Override
	public Comment getComment(int id) {
		return commentDao.getComment(id);
	}

	@Override
	public int getCommentCount(int id) {
		return commentDao.getCommentCount(id);
	}

	@Override
	public Comment postComment(String userId, String commentContent, int id, String receiver) {
		Comment comment = new Comment();
		comment.setUserId(userId);
		comment.setCommentContent(commentContent);
		comment.setBoardId(id);
		commentDao.postComment(comment);
		commentDao.setCommentGroup(comment.getCommentId(), comment.getCommentId());
		if (!receiver.equals(userId)) {
			alarmDao.addCommentAlarm(receiver, userId, id, comment.getCommentId());
		}

		return comment;
	}

	@Override
	public Comment postReComment(String userId, String reCommentContent, int boardId, int parentId, String receiver) {
		Comment comment = new Comment();
		comment.setUserId(userId);
		comment.setCommentContent(reCommentContent);
		comment.setBoardId(boardId);
		comment.setParentId(parentId);
		commentDao.postReComment(comment);
		commentDao.setCommentGroup(comment.getCommentId(), parentId);
		if (!receiver.equals(userId)) {
			alarmDao.addReCommentAlarm(receiver, userId, comment.getCommentId(), boardId);
		}

		return comment;
	}

	@Override
	public int deleteComment(int cid) {

		int childCount = 0;
		childCount = commentDao.getChildCount(cid);
		if (childCount == 0) {
			return commentDao.deleteComment(cid);
		} else {
			return commentDao.setCommentDeletedTrue(cid);
		}

	}

	@Override
	public void deleteComments(List<Integer> chkArray) {
		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			commentDao.deleteComment(id);
		}
	}

	@Override
	public int getCommentCurrentPage(int commentId, int boardId) {

		int result = commentDao.getCommentCurrentPage(commentId, boardId);
		if (result % 10 == 0) {
			return result / 10;
		} else {
			return (result / 10) + 1;
		}

	}

}
