package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.VisitDto;

public interface AdminMapper {
	int visituser(String userid);
	
	List<VisitDto> weekvisiterlist();
	
	int todayvisiter();
	
	int monthvisiter();
	
	int manvisitcount();
	
	int womanvisitcount();
	
	List<UserDto> alluserlist();
	
	int deleteuser(String userid);
}
