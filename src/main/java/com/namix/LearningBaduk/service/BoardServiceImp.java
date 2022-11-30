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
		
		List<BoardView> freeBoards = boardDao.getBoards("freeBoard", 0, 5, "boardTitle", "");
		List<BoardView> ruleBoards = boardDao.getBoards("ruleBoard", 0, 5, "boardTitle", "");
		List<BoardView> patternBoards = boardDao.getBoards("patternBoard", 0, 5, "boardTitle", "");
		List<BoardView> openingBoards = boardDao.getBoards("openingBoard", 0, 5, "boardTitle", "");
		List<BoardView> endGameBoards = boardDao.getBoards("endGameBoard", 0, 5, "boardTitle", "");
		List<BoardView> lifeDeathBoards = boardDao.getBoards("lifeDeathBoard", 0, 5, "boardTitle", "");
		List<BoardView> quetionBoards = boardDao.getBoards("quetionBoard", 0, 5, "boardTitle", "");
		List<BoardView> scheduleBoards = boardDao.getBoards("scheduleBoard", 0, 5, "boardTitle", "");
		List<BoardView> noticeBoards = boardDao.getBoards("noticeBoard", 0, 5, "boardTitle", "");

		map.put("free", freeBoards);
		map.put("rule", ruleBoards);
		map.put("pattern", patternBoards);
		map.put("opening", openingBoards);
		map.put("endGame", endGameBoards);
		map.put("lifeDeath", lifeDeathBoards);
		map.put("quetion", quetionBoards);
		map.put("schedule", scheduleBoards);
		map.put("notice", noticeBoards);

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
			String oldBoardDateStr = board.getBoardDate();
			SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			Date oldBoardDate = new Date();
			int compare = 1;

			try {
				oldBoardDate = parseFormat.parse(oldBoardDateStr);
			} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			}

			Calendar now = Calendar.getInstance();
			Calendar oldBoardDateCal = Calendar.getInstance();
			oldBoardDateCal.setTime(oldBoardDate);

			int yearDif = now.get(Calendar.YEAR) - oldBoardDateCal.get(Calendar.YEAR);
			int monthDif = now.get(Calendar.MONTH) - oldBoardDateCal.get(Calendar.MONTH);
			int dayDif = now.get(Calendar.DATE) - oldBoardDateCal.get(Calendar.DATE);

			if (yearDif == 0 && monthDif == 0 && dayDif == 0) {
				compare = 0;
			}

			if (compare >= 1) {
				String newBoardDateStr = dateFormat.format(oldBoardDate);
				board.setBoardDate(newBoardDateStr);
			} else {
				String newBoardDateStr = timeFormat.format(oldBoardDate);
				board.setBoardDate(newBoardDateStr);
			}

		}

		return boards;
	}

	@Override
	public BoardView getDetailBoard(int id) {

		BoardView board = boardDao.getDetailBoard(id);

		String oldBoardDateStr = board.getBoardDate();
		SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Date oldBoardDate = new Date();
		int compare = 1;

		try {
			oldBoardDate = parseFormat.parse(oldBoardDateStr);
		} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
		}

		Calendar now = Calendar.getInstance();
		Calendar oldBoardDateCal = Calendar.getInstance();
		oldBoardDateCal.setTime(oldBoardDate);

		int yearDif = now.get(Calendar.YEAR) - oldBoardDateCal.get(Calendar.YEAR);
		int monthDif = now.get(Calendar.MONTH) - oldBoardDateCal.get(Calendar.MONTH);
		int dayDif = now.get(Calendar.DATE) - oldBoardDateCal.get(Calendar.DATE);

		if (yearDif == 0 && monthDif == 0 && dayDif == 0) {
			compare = 0;
		}

		if (compare >= 1) {
			String newBoardDateStr = dateFormat.format(oldBoardDate);
			board.setBoardDate(newBoardDateStr);
		} else {
			String newBoardDateStr = timeFormat.format(oldBoardDate);
			board.setBoardDate(newBoardDateStr);
		}

		return board;

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
	public List<BoardView> getMyWritingBoards(int page, String query, String userId) {

		int size = 10;
		int offset = 0 + (page - 1) * size;

		List<BoardView> boards = boardDao.getMyWritingBoards(page, query, userId, size, offset);

		for (int i = 0; i < boards.size(); i++) {

			BoardView board = boards.get(i);
			String oldBoardDateStr = board.getBoardDate();
			SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			Date oldBoardDate = new Date();
			int compare = 1;

			try {
				oldBoardDate = parseFormat.parse(oldBoardDateStr);
			} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			}

			Calendar now = Calendar.getInstance();
			Calendar oldBoardDateCal = Calendar.getInstance();
			oldBoardDateCal.setTime(oldBoardDate);

			int yearDif = now.get(Calendar.YEAR) - oldBoardDateCal.get(Calendar.YEAR);
			int monthDif = now.get(Calendar.MONTH) - oldBoardDateCal.get(Calendar.MONTH);
			int dayDif = now.get(Calendar.DATE) - oldBoardDateCal.get(Calendar.DATE);

			if (yearDif == 0 && monthDif == 0 && dayDif == 0) {
				compare = 0;
			}

			if (compare >= 1) {
				String newBoardDateStr = dateFormat.format(oldBoardDate);
				board.setBoardDate(newBoardDateStr);
			} else {
				String newBoardDateStr = timeFormat.format(oldBoardDate);
				board.setBoardDate(newBoardDateStr);
			}

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
			String oldBoardDateStr = board.getMyBoardDate();
			SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			Date oldBoardDate = new Date();
			int compare = 1;

			try {
				oldBoardDate = parseFormat.parse(oldBoardDateStr);
			} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			}

			Calendar now = Calendar.getInstance();
			Calendar oldBoardDateCal = Calendar.getInstance();
			oldBoardDateCal.setTime(oldBoardDate);

			int yearDif = now.get(Calendar.YEAR) - oldBoardDateCal.get(Calendar.YEAR);
			int monthDif = now.get(Calendar.MONTH) - oldBoardDateCal.get(Calendar.MONTH);
			int dayDif = now.get(Calendar.DATE) - oldBoardDateCal.get(Calendar.DATE);

			if (yearDif == 0 && monthDif == 0 && dayDif == 0) {
				compare = 0;
			}

			if (compare >= 1) {
				String newBoardDateStr = dateFormat.format(oldBoardDate);
				board.setMyBoardDate(newBoardDateStr);
			} else {
				String newBoardDateStr = timeFormat.format(oldBoardDate);
				board.setMyBoardDate(newBoardDateStr);
			}

		}

		return boards;
	}

	@Override
	public MyBoard getMyDetailBoard(int id) {

		MyBoard board = boardDao.getMyDetailBoard(id);

		String oldBoardDateStr = board.getMyBoardDate();
		SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Date oldBoardDate = new Date();
		int compare = 1;

		try {
			oldBoardDate = parseFormat.parse(oldBoardDateStr);
		} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
		}

		Calendar now = Calendar.getInstance();
		Calendar oldBoardDateCal = Calendar.getInstance();
		oldBoardDateCal.setTime(oldBoardDate);

		int yearDif = now.get(Calendar.YEAR) - oldBoardDateCal.get(Calendar.YEAR);
		int monthDif = now.get(Calendar.MONTH) - oldBoardDateCal.get(Calendar.MONTH);
		int dayDif = now.get(Calendar.DATE) - oldBoardDateCal.get(Calendar.DATE);

		if (yearDif == 0 && monthDif == 0 && dayDif == 0) {
			compare = 0;
		}

		if (compare >= 1) {
			String newBoardDateStr = dateFormat.format(oldBoardDate);
			board.setMyBoardDate(newBoardDateStr);
		} else {
			String newBoardDateStr = timeFormat.format(oldBoardDate);
			board.setMyBoardDate(newBoardDateStr);
		}

		return board;

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
	public int getMyDetailsPage(int id) {

		int detailsRowNumber = boardDao.getMyDetailsRowNumber(id) - 1;
		int detailsPage = (int) (Math.ceil(detailsRowNumber / 10) * 10) / 10 + 1;

		if (detailsPage <= 1) {
			detailsPage = 1;
		}

		return detailsPage;
	}

	@Override
	public int getUsersLastBoardId(String userId) {
		return boardDao.getUsersLastBoardId(userId);
	}

	@Override
	public String getBoardsUser(int id) {
		return boardDao.getBoardsUser(id);
	}

	@Override
	public int getUsersLastMyBoardId(String userId) {
		return boardDao.getUsersLastMyBoardId(userId);
	}

	@Override
	public void deleteBoards(List<Integer> chkArray) {
		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			detailDao.deleteDetail(id);
		}
	}

	@Override
	public List<BoardView> getReportBoards(Integer page, String field, String query) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		List<BoardView> boards = boardDao.getReportBoards(offset, size, field, query);

		for (int i = 0; i < boards.size(); i++) {

			BoardView board = boards.get(i);
			String oldBoardDateStr = board.getBoardDate();
			SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			Date oldBoardDate = new Date();
			int compare = 1;

			try {
				oldBoardDate = parseFormat.parse(oldBoardDateStr);
			} catch (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
			}

			Calendar now = Calendar.getInstance();
			Calendar oldBoardDateCal = Calendar.getInstance();
			oldBoardDateCal.setTime(oldBoardDate);

			int yearDif = now.get(Calendar.YEAR) - oldBoardDateCal.get(Calendar.YEAR);
			int monthDif = now.get(Calendar.MONTH) - oldBoardDateCal.get(Calendar.MONTH);
			int dayDif = now.get(Calendar.DATE) - oldBoardDateCal.get(Calendar.DATE);

			if (yearDif == 0 && monthDif == 0 && dayDif == 0) {
				compare = 0;
			}

			if (compare >= 1) {
				String newBoardDateStr = dateFormat.format(oldBoardDate);
				board.setBoardDate(newBoardDateStr);
			} else {
				String newBoardDateStr = timeFormat.format(oldBoardDate);
				board.setBoardDate(newBoardDateStr);
			}

		}

		return boards;

	}

	@Override
	public int getReportPageCount(String field, String query) {
		return boardDao.getReportPageCount(field, query);
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
	public String getCategory(int id) {
		String categoryTmp = boardDao.getCategory(id);
		String ct = categoryTmp.replace("Board", "");
		return ct;
	}

}
