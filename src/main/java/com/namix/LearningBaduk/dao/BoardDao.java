package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.BoardView;

public interface BoardDao {
	
	List<BoardView> getBoards(String category, int offset, int size, String field, String query);
	int getPageCount(String category, String field, String query);
	int writeDetail(String category, String title, String content, String userId);
	
}
