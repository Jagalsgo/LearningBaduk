package com.namix.LearningBaduk.service;

import java.util.List;

import com.namix.LearningBaduk.entity.BoardView;

public interface BoardService {

	List<BoardView> getBoards(int page, String field, String query);
	int getPageCount(String field, String query);
	
}
