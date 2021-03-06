package com.namix.LearningBaduk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.MessageView;
import com.namix.LearningBaduk.entity.MyBoard;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private UserDao userDao;

	@Override
	public List<BoardView> getBoards(String category, int page) {
		return getBoards(category, page, "boardTitle", "");
	}

	@Override
	public List<BoardView> getBoards(String category, int page, String field, String query) {

		int size = 10;
		int offset = 0 + (page - 1) * size;

		return boardDao.getBoards(category, offset, size, field, query);
	}

	@Override
	public int getPageCount(String category) {
		return getPageCount(category, "boardTitle", "");
	}

	@Override
	public int getPageCount(String category, String field, String query) {
		return boardDao.getPageCount(category, field, query);
	}

	@Override
	public int writeDetail(String category, String title, String content, String userId) {
		return boardDao.writeDetail(category, title, content, userId);
	}

	@Override
	public BoardView getDetailBoard(int id) {
		return boardDao.getDetailBoard(id);
	}

	@Override
	public int updateDetail(int id, String title, String content) {
		return boardDao.updateDetail(id, title, content);
	}

	@Override
	public int deleteDetail(int id) {
		return boardDao.deleteDetail(id);
	}

	@Override
	public List<Comment> getComments(int id) {
		return getComments(id, 1);
	}

	@Override
	public List<Comment> getComments(int id, int page) {

		int size = 10;
		int offset = 0 + (page - 1) * size;

		return boardDao.getComments(id, size, offset);
	}

	@Override
	public int getCommentCount(int id) {
		return boardDao.getCommentCount(id);
	}

	@Override
	public int getUsersLastBoardId(String userId) {
		return boardDao.getUsersLastBoardId(userId);
	}

	@Override
	public void addHit(int id) {
		boardDao.addHit(id);

	}

	@Override
	public String getBoardsUser(int id) {
		return boardDao.getBoardsUser(id);
	}

	@Override
	public int likeClicked(int id, String userId) {
		return boardDao.likeClicked(id, userId);
	}

	@Override
	public int DislikeClicked(int id, String userId) {
		return boardDao.dislikeClicked(id, userId);
	}

	@Override
	public int addLike(int id, String userId) {
		return boardDao.addLike(id, userId);
	}

	@Override
	public int addDislike(int id, String userId) {
		return boardDao.addDislike(id, userId);
	}

	@Override
	public int getLikeCount(int id) {
		return boardDao.getLikeCount(id);
	}

	@Override
	public int getDislikeCount(int id) {
		return boardDao.getDislikeCount(id);
	}

	@Override
	public Comment postComment(String userId, String commentContent, int id, String receiver) {
		Comment comment = new Comment();
		comment.setUserId(userId);
		comment.setCommentContent(commentContent);
		comment.setBoardId(id);
		boardDao.postComment(comment);
		boardDao.setCommentGroup(comment.getCommentId(), comment.getCommentId());
		if (!receiver.equals(userId)) {
			boardDao.addCommentAlarm(receiver, userId, id, comment.getCommentId());
		}

		return comment;
	}

	@Override
	public int deleteComment(int cid) {

		int childCount = 0;
		childCount = boardDao.getChildCount(cid);
		if (childCount == 0) {
			return boardDao.deleteComment(cid);
		} else {
			return boardDao.setCommentDeletedTrue(cid);
		}

	}

	@Override
	public int getDetailsPage(int id) {

		int detailsRowNumber = boardDao.getDetailsRowNumber(id) - 1;
		int detailsPage = (int) (Math.ceil(detailsRowNumber / 10) * 10) / 10 + 1;

		if (detailsPage <= 1) {
			detailsPage = 1;
		}

		return detailsPage;
	}

	@Override
	public List<BoardView> getMyWritingBoards(int page, String query, String userId) {

		int size = 10;
		int offset = 0 + (page - 1) * size;

		return boardDao.getMyWritingBoards(page, query, userId, size, offset);
	}

	@Override
	public int getMyWritingPageCount(String query, String userId) {
		return boardDao.getMyWritingPageCount(query, userId);
	}

	@Override
	public List<MyBoard> getMyOwnBoards(int page, String query, String userId) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		return boardDao.getMyOwnBoards(page, query, userId, size, offset);
	}

	@Override
	public int getMyOwnPageCount(String userId) {
		return boardDao.getMyOwnPageCount("", userId);
	}

	@Override
	public int getMyOwnPageCount(String query, String userId) {
		return boardDao.getMyOwnPageCount(query, userId);
	}

	@Override
	public int writeMyDetail(String title, String content, String userId) {
		return boardDao.writeMyDetail(title, content, userId);
	}

	@Override
	public int getUsersLastMyBoardId(String userId) {
		return boardDao.getUsersLastMyBoardId(userId);
	}

	@Override
	public MyBoard getMyDetailBoard(int id) {
		return boardDao.getMyDetailBoard(id);
	}

	@Override
	public int getMyDetailsPage(int id) {

		int detailsRowNumber = boardDao.getMyDetailsRowNumber(id) - 1;

		int detailsPage = (int) (Math.ceil(detailsRowNumber / 10) * 10) / 10 + 1;

		if (detailsPage <= 1) {
			detailsPage = 1;
		}

		return detailsPage;
	}

	@Override
	public int deleteMyDetail(int id) {
		return boardDao.deleteMyDetail(id);
	}

	@Override
	public int updateMyDetail(int id, String title, String content) {
		return boardDao.updateMyDetail(id, title, content);
	}

	@Override
	public void deleteBoards(List<Integer> chkArray) {
		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			boardDao.deleteDetail(id);
		}
	}

	@Override
	public void deleteComments(List<Integer> chkArray) {
		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			boardDao.deleteComment(id);
		}
	}

	@Override
	public List<BoardView> getReportBoards(Integer page, String field, String query) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		return boardDao.getReportBoards(offset, size, field, query);
	}

	@Override
	public int getReportPageCount(String field, String query) {
		return boardDao.getReportPageCount(field, query);
	}

	@Override
	public void initBoardReports(List<Integer> chkArray) {
		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			boardDao.initBoardReport(id);
		}
		for (int i = 0; i < chkArray.size(); i++) {
			String boardIdString = Integer.toString(chkArray.get(i));
			boardDao.deleteBoardReportList(boardIdString);
		}
	}

	@Override
	public Map<String, Object> getHomeBoards() {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("free", boardDao.getBoards("freeBoard", 0, 5, "boardTitle", ""));
		map.put("rule", boardDao.getBoards("ruleBoard", 0, 5, "boardTitle", ""));
		map.put("pattern", boardDao.getBoards("patternBoard", 0, 5, "boardTitle", ""));
		map.put("opening", boardDao.getBoards("openingBoard", 0, 5, "boardTitle", ""));
		map.put("endGame", boardDao.getBoards("endGameBoard", 0, 5, "boardTitle", ""));
		map.put("quetion", boardDao.getBoards("quetionBoard", 0, 5, "boardTitle", ""));
		map.put("schedule", boardDao.getBoards("scheduleBoard", 0, 5, "boardTitle", ""));
		map.put("notice", boardDao.getBoards("noticeBoard", 0, 5, "boardTitle", ""));

		return map;
	}

	@Override
	public int reportBoard(int boardId, String userId) {

		String boardIdString = Integer.toString(boardId);
		int haveReported = boardDao.haveYouReported(boardIdString, userId);
		if (haveReported >= 1) {
			return -1;
		} else {
			boardDao.addBoardReport(boardId);
			userDao.postReportList("board", boardIdString, "", userId);
			return 1;
		}

	}

	@Override
	public List<MessageView> getMessages(Integer page, String field, String query, String messageField,
			String messageQuery, String deleted) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		return boardDao.getMessages(offset, size, field, query, messageField, messageQuery, deleted);
	}

	@Override
	public int getMessageCount(String field, String query, String messageField, String messageQuery, String deleted) {
		return boardDao.getMessageCount(field, query, messageField, messageQuery, deleted);
	}

	@Override
	public void deleteMessage(List<Integer> chkArray, String deleted) {

		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			boardDao.deleteMessage(id, deleted);
			Message message = userDao.getMessage(id);
			if (message.isDeleteByReceiver() && message.isDeleteBySender()) {
				boardDao.deleteDbMessage(id);
			}
		}

	}

	@Override
	public MessageView getMessage(int id) {
		return boardDao.getMessage(id);
	}

	@Override
	public void deleteMessageDetail(int id, String deleted) {

		boardDao.deleteMessage(id, deleted);
		Message message = userDao.getMessage(id);
		if (message.isDeleteByReceiver() && message.isDeleteBySender()) {
			boardDao.deleteDbMessage(id);
		}

	}

	@Override
	public String getCategory(int id) {
		String categoryTmp = boardDao.getCategory(id);
		String ct = categoryTmp.replace("Board", "");
		return ct;
	}

	@Override
	public Comment getComment(int id) {
		return boardDao.getComment(id);
	}

	@Override
	public Comment postReComment(String userId, String reCommentContent, int boardId, int parentId, String receiver) {
		Comment comment = new Comment();
		comment.setUserId(userId);
		comment.setCommentContent(reCommentContent);
		comment.setBoardId(boardId);
		comment.setParentId(parentId);
		boardDao.postReComment(comment);
		boardDao.setCommentGroup(comment.getCommentId(), parentId);
		if (!receiver.equals(userId)) {
			boardDao.addReCommentAlarm(receiver, userId, comment.getCommentId(), boardId);
		}

		return comment;
	}

	@Override
	public int getCommentCurrentPage(int commentId, int boardId) {

		int result = boardDao.getCommentCurrentPage(commentId, boardId);
		if (result % 10 == 0) {
			return result / 10;
		} else {
			return (result / 10) + 1;
		}

	}

}
