package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.BoardView;

public interface BoardDao {
	
	List<BoardView> getBoards(int offset, int size, String field, String query);
	int getPageCount(String field, String query);
	
}
