package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.entity.BoardView;

@Repository
public class MybatisBoardDao implements BoardDao {

	private BoardDao boardDaoMapper;
	
	@Autowired
	public MybatisBoardDao(SqlSession sqlsession) {
		boardDaoMapper = sqlsession.getMapper(BoardDao.class);
	}
	
	@Override
	public List<BoardView> getBoards(String category, int offset, int size, String field, String query) {
		return boardDaoMapper.getBoards(category, offset, size, field, query);
	}

	@Override
	public int getPageCount(String category, String field, String query) {
		return boardDaoMapper.getPageCount(category, field, query);
	}

	@Override
	public int writeDetail(String category, String title, String content, String userId) {
		return boardDaoMapper.writeDetail(category, title, content, userId);
	}

}
