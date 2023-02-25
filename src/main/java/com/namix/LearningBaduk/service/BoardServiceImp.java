package com.namix.LearningBaduk.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.dao.DetailDao;
import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Category;
import com.namix.LearningBaduk.entity.MyBoard;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private DetailDao detailDao;

	@Override
	public Map<String, Object> getHomeBoards() {

		Map<String, Object> map = new HashMap<String, Object>();

		for (String ct : Category.ctList) {

			String ctBoard = ct + "Board";
			List<BoardView> ctBoards = boardDao.getBoards(ctBoard, 0, 5, "boardTitle", "");
			map.put(ct, ctBoards);

		}

		return map;
	}

	@Override
	public List<BoardView> getBoards(String category, int page) {
		return getBoards(category, page, "boardTitle", "");
	}

	@Override
	public List<BoardView> getBoards(String category, int page, String field, String query) {

		int size = 10;
		int offset = 0 + (page - 1) * size;

		List<BoardView> boards = boardDao.getBoards(category, offset, size, field, query);

		for (int i = 0; i < boards.size(); i++) {

			BoardView board = boards.get(i);
			String newBoardDate = changeDateFormat(board.getBoardDate());
			board.setBoardDate(newBoardDate);

		}

		return boards;
	}

	@Override
	public int getPageCount(String category) {
		return getPageCount(category, "boardTitle", "");
	}

	@Override
	public int getPageCount(String category, String field, String query) {
		return boardDao.getPageCount(category, field, query);
	}
	
	@Override
	public BoardView getDetailBoard(int id) {

		BoardView board = boardDao.getDetailBoard(id);
		String newBoardDate = changeDateFormat(board.getBoardDate());
		board.setBoardDate(newBoardDate);

		return board;

	}

	@Override
	public List<BoardView> getMyWritingBoards(int page, String query, String userId) {

		int size = 10;
		int offset = 0 + (page - 1) * size;

		List<BoardView> boards = boardDao.getMyWritingBoards(page, query, userId, size, offset);

		for (int i = 0; i < boards.size(); i++) {

			BoardView board = boards.get(i);
			String newBoardDate = changeDateFormat(board.getBoardDate());
			board.setBoardDate(newBoardDate);

		}

		return boards;
	}

	@Override
	public int getMyWritingPageCount(String query, String userId) {
		return boardDao.getMyWritingPageCount(query, userId);
	}

	@Override
	public List<MyBoard> getMyOwnBoards(int page, String query, String userId) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		List<MyBoard> boards = boardDao.getMyOwnBoards(page, query, userId, size, offset);

		for (int i = 0; i < boards.size(); i++) {

			MyBoard board = boards.get(i);
			String newBoardDate = changeDateFormat(board.getMyBoardDate());
			board.setMyBoardDate(newBoardDate);

		}

		return boards;
	}

	@Override
	public int getMyOwnPageCount(String userId) {
		return boardDao.getMyOwnPageCount("", userId);
	}

	@Override
	public int getMyOwnPageCount(String query, String userId) {
		return boardDao.getMyOwnPageCount(query, userId);
	}
	
	@Override
	public MyBoard getMyDetailBoard(int id) {

		MyBoard board = boardDao.getMyDetailBoard(id);
		String newBoardDate = changeDateFormat(board.getMyBoardDate());
		board.setMyBoardDate(newBoardDate);

		return board;

	}
	
	@Override
	public List<BoardView> getReportBoards(Integer page, String field, String query) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		List<BoardView> boards = boardDao.getReportBoards(offset, size, field, query);

		for (int i = 0; i < boards.size(); i++) {

			BoardView board = boards.get(i);
			String newBoardDate = changeDateFormat(board.getBoardDate());
			board.setBoardDate(newBoardDate);

		}

		return boards;

	}
	
	@Override
	public int getReportedBoardCount(String field, String query) {
		return boardDao.getReportedBoardCount(field, query);
	}
	
	@Override
	public int reportBoard(int boardId, String userId) {

		String boardIdString = Integer.toString(boardId);
		int haveReported = boardDao.haveYouReported(boardIdString, userId);
		if (haveReported >= 1) {
			return -1;
		} else {
			boardDao.addBoardReport(boardId);
			userDao.postReportList("board", boardIdString, "", userId);
			return 1;
		}

	}

	@Override
	public void deleteBoards(List<Integer> chkArray) {
		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			detailDao.deleteDetail(id);
		}
	}

	@Override
	public void initBoardReports(List<Integer> chkArray) {
		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			boardDao.initBoardReport(id);
		}
		for (int i = 0; i < chkArray.size(); i++) {
			String boardIdString = Integer.toString(chkArray.get(i));
			boardDao.deleteBoardReportList(boardIdString);
		}
	}

	@Override
	public int getUsersLastBoardId(String userId) {
		return boardDao.getUsersLastBoardId(userId);
	}
	
	@Override
	public int getUsersLastMyBoardId(String userId) {
		return boardDao.getUsersLastMyBoardId(userId);
	}

	@Override
	public String getBoardsUser(int id) {
		return boardDao.getBoardsUser(id);
	}

	@Override
	public String getCategory(int id) {
		String categoryTmp = boardDao.getCategory(id);
		String ct = categoryTmp.replace("Board", "");
		return ct;
	}

	@Override
	public String changeDateFormat(String oldBoardDateStr) {

		SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

		Date oldBoardDate = new Date();
		int compare = 1;
		String newBoardDateStr = oldBoardDateStr;

		try {
			oldBoardDate = parseFormat.parse(oldBoardDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar now = Calendar.getInstance();
		Calendar oldBoardDateCal = Calendar.getInstance();
		oldBoardDateCal.setTime(oldBoardDate);

		// Check Date Difference
		int yearDif = now.get(Calendar.YEAR) - oldBoardDateCal.get(Calendar.YEAR);
		int monthDif = now.get(Calendar.MONTH) - oldBoardDateCal.get(Calendar.MONTH);
		int dayDif = now.get(Calendar.DATE) - oldBoardDateCal.get(Calendar.DATE);

		if (yearDif == 0 && monthDif == 0 && dayDif == 0) {
			compare = 0;
		}

		if (compare >= 1) /* Different Day */ {
			newBoardDateStr = dateFormat.format(oldBoardDate);
		} else /* Same Day */ {
			newBoardDateStr = timeFormat.format(oldBoardDate);
		}

		return newBoardDateStr;

	}

}
