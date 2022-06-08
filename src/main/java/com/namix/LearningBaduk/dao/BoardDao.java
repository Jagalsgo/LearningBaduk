package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.MyBoard;

public interface BoardDao {
	
	List<BoardView> getBoards(String category, int offset, int size, String field, String query);
	int getPageCount(String category, String field, String query);
	int writeDetail(String category, String title, String content, String userId);
	BoardView getDetailBoard(int id);
	int updateDetail(int id, String title, String content);
	int deleteDetail(int id);
	List<Comment> getComments(int id, int size, int offset);
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
	int postComment(String userId, String commentContent, int id);
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
	
}
