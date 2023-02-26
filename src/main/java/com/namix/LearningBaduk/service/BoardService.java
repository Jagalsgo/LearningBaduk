package com.namix.LearningBaduk.service;

import java.util.List;
import java.util.Map;

import com.namix.LearningBaduk.entity.Board;
import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;
import com.namix.LearningBaduk.entity.MessageView;
import com.namix.LearningBaduk.entity.MyBoard;

public interface BoardService {

	Map<String, Object> getHomeBoards();

	List<BoardView> getBoards(String category, int page);
	List<BoardView> getBoards(String category, int page, String field, String query);

	int getPageCount(String categoryEng);
	int getPageCount(String category, String field, String query);
	
	BoardView getDetailBoard(int id);

	List<BoardView> getMyWritingBoards(int page, String query, String userId);

	int getMyWritingPageCount(String query, String userId);

	List<MyBoard> getMyOwnBoards(int page, String query, String userId);
	
	int getMyOwnPageCount(String userId);
	int getMyOwnPageCount(String query, String userId);

	MyBoard getMyDetailBoard(int id);

	List<BoardView> getReportedBoards(Integer page, String field, String query);

	int getReportedBoardCount(String field, String query);

	int reportBoard(int boardId, String userId);

	void deleteBoards(List<Integer> chkArray);

	void initBoardReports(List<Integer> chkArray);

	int getUsersLastBoardId(String userId);

	int getUsersLastMyBoardId(String userId);
	
	String getBoardsUser(int id);
	
	String getCategory(int id);
	
	String changeDateFormat(String oldBoardDateStr);

}
