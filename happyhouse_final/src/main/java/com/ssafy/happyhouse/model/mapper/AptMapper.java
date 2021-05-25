package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.NewsDto;

public interface AptMapper {
	List<HouseInfoDto> aptdonglist(String dong);

	List<HouseInfoDto> aptnamelist(String aptname);
	
	List<HouseInfoDto> topaptlist();
	
	List<NewsDto> newslist();
}
