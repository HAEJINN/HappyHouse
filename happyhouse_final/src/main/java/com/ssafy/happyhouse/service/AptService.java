package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.HouseInfoDto;

public interface AptService {
	List<HouseInfoDto> houseinfolist(String dong);
}
