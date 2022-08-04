package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;
import com.namix.LearningBaduk.entity.MessageView;
import com.namix.LearningBaduk.entity.MyBoard;

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
	public BoardView getDetailBoard(int id) {
		return boardDaoMapper.getDetailBoard(id);
	}

	@Override
	public int getPageCount(String category, String field, String query) {
		return boardDaoMapper.getPageCount(category, field, query);
	}

	@Override
	public List<BoardView> getMyWritingBoards(int page, String query, String userId, int size, int offset) {
		return boardDaoMapper.getMyWritingBoards(page, query, userId, size, offset);
	}

	@Override
	public int getMyWritingPageCount(String query, String userId) {
		return boardDaoMapper.getMyWritingPageCount(query, userId);
	}

	@Override
	public List<MyBoard> getMyOwnBoards(int page, String query, String userId, int size, int offset) {
		return boardDaoMapper.getMyOwnBoards(page, query, userId, size, offset);
	}

	@Override
	public MyBoard getMyDetailBoard(int id) {
		return boardDaoMapper.getMyDetailBoard(id);
	}

	@Override
	public int getMyOwnPageCount(String query, String userId) {
		return boardDaoMapper.getMyOwnPageCount(query, userId);
	}

	@Override
	public List<BoardView> getReportBoards(int offset, int size, String field, String query) {
		return boardDaoMapper.getReportBoards(offset, size, field, query);
	}

	@Override
	public int getReportPageCount(String field, String query) {
		return boardDaoMapper.getReportPageCount(field, query);
	}

	@Override
	public int getUsersLastMyBoardId(String userId) {
		return boardDaoMapper.getUsersLastMyBoardId(userId);
	}

	@Override
	public int getMyDetailsRowNumber(int id) {
		return boardDaoMapper.getMyDetailsRowNumber(id);
	}

	@Override
	public int getUsersLastBoardId(String userId) {
		return boardDaoMapper.getUsersLastBoardId(userId);
	}

	@Override
	public String getBoardsUser(int id) {
		return boardDaoMapper.getBoardsUser(id);
	}

	@Override
	public int getDetailsRowNumber(int id) {
		return boardDaoMapper.getDetailsRowNumber(id);
	}

	@Override
	public int initBoardReport(int id) {
		return boardDaoMapper.initBoardReport(id);
	}

	@Override
	public int haveYouReported(String boardIdString, String userId) {
		return boardDaoMapper.haveYouReported(boardIdString, userId);
	}

	@Override
	public int addBoardReport(int boardId) {
		return boardDaoMapper.addBoardReport(boardId);
	}

	@Override
	public int deleteBoardReportList(String boardIdString) {
		return boardDaoMapper.deleteBoardReportList(boardIdString);
	}

	@Override
	public String getCategory(int id) {
		return boardDaoMapper.getCategory(id);
	}

}
