package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;
import com.namix.LearningBaduk.entity.MessageView;
import com.namix.LearningBaduk.entity.MyBoard;

public interface BoardDao {
	
	List<BoardView> getBoards(String category, int offset, int size, String field, String query);
	int getPageCount(String category, String field, String query);
	int writeDetail(String category, String title, String content, String userId);
	BoardView getDetailBoard(int id);
	int updateDetail(int id, String title, String content);
	int deleteDetail(int id);
	List<CommentView> getComments(int id, int size, int offset);
	int getCommentCount(int id);
	int getUsersLastBoardId(String userId);
	void addHit(int id);
	String getBoardsUser(int id);
	int likeClicked(int id, String userId);
	int dislikeClicked(int id, String userId);
	int addLike(int id, String userId);
	int addDislike(int id, String userId);
	int getLikeCount(int id);
	int getDislikeCount(int id);
	int postComment(Comment comment);
	int deleteComment(int cid);
	int getDetailsRowNumber(int id);
	List<BoardView> getMyWritingBoards(int page, String query, String userId, int size, int offset);
	int getMyWritingPageCount(String query, String userId);
	List<MyBoard> getMyOwnBoards(int page, String query, String userId, int size, int offset);
	int getMyOwnPageCount(String query, String userId);
	int writeMyDetail(String title, String content, String userId);
	int getUsersLastMyBoardId(String userId);
	MyBoard getMyDetailBoard(int id);
	int getMyDetailsRowNumber(int id);
	int deleteMyDetail(int id);
	int updateMyDetail(int id, String title, String content);
	List<BoardView> getReportBoards(int offset, int size, String field, String query);
	int getReportPageCount(String field, String query);
	int initBoardReport(int id);
	int haveYouReported(String boardIdString, String userId);
	int addBoardReport(int boardId);
	int deleteBoardReportList(String boardIdString);
	List<MessageView> getMessages(int offset, int size, String field, String query, String messageField, String messageQuery, String deleted);
	int getMessageCount(String field, String query, String messageField, String messageQuery, String deleted);
	int deleteMessage(int id, String deleted);
	int deleteDbMessage(int id);
	MessageView getMessage(int id);
	String getCategory(int id);
	int addCommentAlarm(String receiver, String sender, int boardId, int commentId);
	int getChildCount(int cid);
	int setCommentDeletedTrue(int cid);
	Comment getComment(int id);
	int postReComment(Comment comment);
	int addReCommentAlarm(String receiver, String sender, int commentId, int boardId);
	int setCommentGroup(int commentId, int commentGroup);
	int getCommentCurrentPage(int commentId, int boardId);
	
}
