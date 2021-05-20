package com.ssafy.happyhouse.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper mapper;
	
	@Override
	public UserDto login(Map<String, String> map) {
		return mapper.login(map);
	}
	
	@Override
	public String searchpwd(Map<String, String> map) {
		return mapper.searchpwd(map);
	}

	@Override
	public boolean register(UserDto user) {
		if (0 < mapper.register(user))
			return true;
		return false;
	}

	@Override
	public boolean modifyuser(UserDto user) {
		if (0 < mapper.modifyuser(user))
			return true;
		return false;
	}

	@Override
	public boolean deleteuser(UserDto user) {
		if (0 < mapper.deleteuser(user))
			return true;
		return false;
	}
}
