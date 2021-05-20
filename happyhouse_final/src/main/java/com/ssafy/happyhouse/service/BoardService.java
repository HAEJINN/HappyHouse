package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.BoardDto;

public interface BoardService {
	List<BoardDto> search(Map<String, String> map);
	
	BoardDto detailboard(Map<String, String> map);
	
	boolean registboard(Map<String, String> map);
	
	boolean modifyboard(Map<String, String> map);
	
	boolean deleteboard(Map<String, String> map);
}
