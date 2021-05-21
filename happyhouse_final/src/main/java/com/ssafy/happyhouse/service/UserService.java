package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.UserDto;

public interface UserService {
	UserDto login(Map<String, String> map);
	
	String searchpwd(Map<String, String> map);

	boolean register(UserDto user);

	boolean modifyuser(UserDto user);

	boolean deleteuser(UserDto user);
	
	List<HouseInfoDto> userfavorite(String userid);
}
