package com.ssafy.happyhouse.model.mapper;

import java.util.List;

public interface AdminMapper {
	int visituser(String userid);
	
	List<Integer> weekvisiterlist();
	
	int todayvisiter();
	
	int monthvisiter();
	
	int manvisitcount();
	
	int womanvisitcount();
}
