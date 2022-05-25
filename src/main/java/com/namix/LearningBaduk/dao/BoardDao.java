package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;

public interface BoardDao {
	
	List<BoardView> getBoards(String category, int offset, int size, String field, String query);
	int getPageCount(String category, String field, String query);
	int writeDetail(String category, String title, String content, String userId);
	BoardView getDetailBoard(int id);
	int updateDetail(int id, String title, String content);
	int deleteDetail(int id);
	List<Comment> getComments(int id);
	int getCommentCount(int id);
	
}
