package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.mapper.BaseAddressMapper;

@Service
public class BaseAddressServiceImpl implements BassAddressService{

	@Autowired
	BaseAddressMapper mapper;
	
	@Override
	public List<String> getcity() {
		return mapper.getcity();
	}

	@Override
	public List<String> getgugun(Map<String, String> map) {
		return mapper.getgugun(map);
	}

	@Override
	public List<String> getdong(Map<String, String> map) {
		return mapper.getdong(map);
	}

}
