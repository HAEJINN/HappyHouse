package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper mapper;

	@Override
	public List<BoardDto> search(Map<String, String> map) {
		if(map.get("boardnum") == null)
			map.put("boardnum", "0");
		return mapper.search(map);
	}
	
	@Override
	public BoardDto detailboard(Map<String, String> map) {
		return mapper.detailboard(map);
	}

	@Override
	public boolean registboard(Map<String, String> map) {
		if (0 < mapper.registboard(map))
			return true;
		return false;
	}

	@Override
	public boolean modifyboard(Map<String, String> map) {
		if (0 < mapper.modifyboard(map))
			return true;
		return false;
	}

	@Override
	public boolean deleteboard(Map<String, String> map) {
		if (0 < mapper.deleteboard(map))
			return true;
		return false;
	}
}
