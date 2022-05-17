package com.namix.LearningBaduk.service;

import java.util.List;

import com.namix.LearningBaduk.entity.BoardView;

public interface BoardService {

	List<BoardView> getBoards(String category, int page, String field, String query);
	int getPageCount(String category, String field, String query);
	int writeDetail(String category, String title, String content, String userId);
	
}
