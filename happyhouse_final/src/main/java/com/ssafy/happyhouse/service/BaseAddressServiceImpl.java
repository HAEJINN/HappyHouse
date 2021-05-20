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
	public List<String> getCity() {
		return mapper.getCity();
	}

	@Override
	public List<String> getGugun(Map<String, String> map) {
		return mapper.getGugun(map);
	}

	@Override
	public List<String> getDong(Map<String, String> map) {
		return mapper.getDong(map);
	}

}
