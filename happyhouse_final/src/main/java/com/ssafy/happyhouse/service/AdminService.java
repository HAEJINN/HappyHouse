package com.ssafy.happyhouse.service;

public interface AdminService {
	boolean visituser(String userid);
	
	int weekvisiterlist();

	int todayvisiter();

	int monthvisiter();

	int manvisitcount();

	int womanvisitcount();
}
