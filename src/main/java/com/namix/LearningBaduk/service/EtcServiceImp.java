package com.namix.LearningBaduk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EtcServiceImp implements EtcService {

	@Override
	public Map<String, String> getCategorys(String categoryBoard) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		switch(categoryBoard) {
		
			case "free" : map.put("categoryBoard", "freeBoard");
			map.put("categoryDetail", "freeDetail");
			map.put("categoryKor", "자유게시판");
			map.put("ct", "free");
			break;
											
			case "rule" : map.put("categoryBoard", "ruleBoard");
			map.put("categoryDetail", "ruleDetail");
			map.put("categoryKor", "룰");
			map.put("ct", "rule");
			break;
			
			case "pattern" : map.put("categoryBoard", "patternBoard");
			map.put("categoryDetail", "patternDetail");
			map.put("categoryKor", "정석");
			map.put("ct", "pattern");
			break;
			
			case "opening" : map.put("categoryBoard", "openingBoard");
			map.put("categoryDetail", "openingDetail");
			map.put("categoryKor", "포석");
			map.put("ct", "opening");
			break;
			
			case "endGame" : map.put("categoryBoard", "endGameBoard");
			map.put("categoryDetail", "endGameDetail");
			map.put("categoryKor", "끝내기");
			map.put("ct", "endGame");
			break;
			
			case "quetion" : map.put("categoryBoard", "quetionBoard");
			map.put("categoryDetail", "quetionDetail");
			map.put("categoryKor", "바둑Q&A");
			map.put("ct", "quetion");
			break;
			
			case "notice" : map.put("categoryBoard", "noticeBoard");
			map.put("categoryDetail", "noticeDetail");
			map.put("categoryKor", "공지");
			map.put("ct", "notice");
			break;
		
		}
		
		return map;
	}

}
