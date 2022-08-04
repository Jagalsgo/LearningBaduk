package com.namix.LearningBaduk.service;

import java.util.List;
import java.util.Map;

import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;
import com.namix.LearningBaduk.entity.MessageView;
import com.namix.LearningBaduk.entity.MyBoard;

public interface BoardService {

	// get home board
	Map<String, Object> getHomeBoards();

	// get board
	List<BoardView> getBoards(String category, int page);

	List<BoardView> getBoards(String category, int page, String field, String query);

	BoardView getDetailBoard(int id);

	int getPageCount(String categoryEng);

	int getPageCount(String category, String field, String query);

	// get myWriting board
	List<BoardView> getMyWritingBoards(int page, String query, String userId);

	int getMyWritingPageCount(String query, String userId);

	// get myOwn board
	List<MyBoard> getMyOwnBoards(int page, String query, String userId);

	int getMyOwnPageCount(String userId);

	int getMyOwnPageCount(String query, String userId);

	MyBoard getMyDetailBoard(int id);

	int getMyDetailsPage(int id);

	List<BoardView> getReportBoards(Integer page, String field, String query);

	int getReportPageCount(String field, String query);

	int getUsersLastBoardId(String userId);

	String getBoardsUser(int id);

	int getUsersLastMyBoardId(String userId);

	void deleteBoards(List<Integer> chkArray);

	void initBoardReports(List<Integer> chkArray);

	int reportBoard(int boardId, String userId);

	String getCategory(int id);

}
