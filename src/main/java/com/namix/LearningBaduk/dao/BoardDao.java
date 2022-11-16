package com.namix.LearningBaduk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.MyBoard;

@Mapper
public interface BoardDao {

	List<BoardView> getBoards(String category, int offset, int size, String field, String query);

	BoardView getDetailBoard(int id);

	int getPageCount(String category, String field, String query);

	List<BoardView> getMyWritingBoards(int page, String query, String userId, int size, int offset);

	int getMyWritingPageCount(String query, String userId);

	List<MyBoard> getMyOwnBoards(int page, String query, String userId, int size, int offset);

	MyBoard getMyDetailBoard(int id);

	int getMyOwnPageCount(String query, String userId);

	List<BoardView> getReportBoards(int offset, int size, String field, String query);

	int getReportPageCount(String field, String query);

	int getUsersLastBoardId(String userId);

	int getUsersLastMyBoardId(String userId);

	int getMyDetailsRowNumber(int id);

	int getDetailsRowNumber(int id);

	String getBoardsUser(int id);

	int initBoardReport(int id);

	int haveYouReported(String boardIdString, String userId);

	int addBoardReport(int boardId);

	int deleteBoardReportList(String boardIdString);

	String getCategory(int id);

}
