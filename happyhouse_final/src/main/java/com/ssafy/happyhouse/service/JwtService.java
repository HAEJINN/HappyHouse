package com.ssafy.happyhouse.service;

import java.util.Map;

import com.ssafy.happyhouse.model.UserDto;

public interface JwtService {

	<T> String create(String key, T data, String subject);
	Map<String, Object> get();
	boolean isUsable(String jwt);
	public UserDto getUserDto();
	
}
