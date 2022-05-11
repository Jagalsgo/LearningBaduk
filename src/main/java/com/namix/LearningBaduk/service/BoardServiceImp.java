package com.namix.LearningBaduk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.entity.BoardView;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardView> getBoards(String category, int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
		
		return boardDao.getBoards(category, offset, size, field, query);
	}

	@Override
	public int getPageCount(String category, String field, String query) {
		return boardDao.getPageCount(category, field, query);
	}

}
