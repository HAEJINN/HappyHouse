package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.PosDto;

public interface PosMapper {
	List<PosDto> convenlist();
	
	List<PosDto> cctvlist();
	
	List<PosDto> cafelist();
	
	List<PosDto> pharlist();
}
