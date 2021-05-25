package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.UserDto;

public interface UserMapper {
	UserDto login(Map<String, String> map);
	
	String searchpwd(Map<String, String> map);

	int register(UserDto user);

	int modifyuser(UserDto user);

	int deleteuser(UserDto user);
	
	List<HouseInfoDto> userfavorite(String userid);
	
	int insertuserfavorite(Map<String, String> map);
	
	int deletuserfavorite(Map<String, String> map);
}