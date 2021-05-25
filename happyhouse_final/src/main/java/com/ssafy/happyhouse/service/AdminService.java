package com.ssafy.happyhouse.service;

import java.util.List;

public interface AdminService {
	boolean visituser(String userid);
	
	List<Integer> weekvisiterlist();

	int todayvisiter();

	int monthvisiter();

	int manvisitcount();

	int womanvisitcount();
}
