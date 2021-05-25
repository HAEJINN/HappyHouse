package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.VisitDto;

public interface AdminService {
	boolean visituser(String userid);
	
	List<VisitDto> weekvisiterlist();

	int todayvisiter();

	int monthvisiter();

	int manvisitcount();

	int womanvisitcount();
	
	List<UserDto> alluserlist();
	
	boolean deleteuser(String userid);
}
