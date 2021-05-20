package com.ssafy.happyhouse.model.mapper;

public interface AdminMapper {
	int visituser(String userid);
	
	int todayvisiter();
	
	int monthvisiter();
	
	int manvisitcount();
	
	int womanvisitcount();
}
