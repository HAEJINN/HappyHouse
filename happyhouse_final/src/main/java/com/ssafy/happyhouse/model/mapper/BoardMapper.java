package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.BoardDto;

public interface BoardMapper{
	
	List<BoardDto> search(Map<String, String> map);
	
	BoardDto detailboard(Map<String, String> map);
	
	int registboard(Map<String, String> map);
	
	int modifyboard(Map<String, String> map);
	
	int deleteboard(Map<String, String> map);
}
