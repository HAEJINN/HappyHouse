package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.mapper.AptMapper;

@Service
public class AptServiceImpl implements AptService{

	@Autowired
	AptMapper mapper;
	
	@Override
	public List<HouseInfoDto> houseinfolist(String dong) {
		return mapper.houseinfolist(dong);
	}

}
