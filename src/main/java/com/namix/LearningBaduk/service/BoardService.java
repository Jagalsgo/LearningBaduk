package com.namix.LearningBaduk.service;

import java.util.List;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;

public interface BoardService {

	List<BoardView> getBoards(String category, int page, String field, String query);
	int getPageCount(String category, String field, String query);
	int writeDetail(String category, String title, String content, String userId);
	BoardView getDetailBoard(int id);
	int updateDetail(int id, String title, String content);
	int deleteDetail(int id);
	List<Comment> getComments(int id);
	int getCommentCount(int id);
	int getPageCount(String categoryEng);
	int getUsersLastBoardId(String userId);
	void addHit(int id);
	String getBoardsUser(int id);
	int likeClicked(int id, String userId);
	int DislikeClicked(int id, String userId);
	int addLike(int id, String userId);
	int addDislike(int id, String userId);
	int getLikeCount(int id);
	int getDislikeCount(int id);
	
}
