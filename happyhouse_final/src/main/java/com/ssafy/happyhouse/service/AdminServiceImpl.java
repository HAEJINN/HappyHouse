package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.VisitDto;
import com.ssafy.happyhouse.model.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper mapper;

	@Override
	public boolean visituser(String userid) {
		if (0 < mapper.visituser(userid))
			return true;
		return false;
	}

	@Override
	public List<VisitDto> weekvisiterlist() {
		return mapper.weekvisiterlist();
	}

	@Override
	public int todayvisiter() {
		return mapper.todayvisiter();
	}

	@Override
	public int monthvisiter() {
		return mapper.monthvisiter();
	}

	@Override
	public int manvisitcount() {
		return mapper.manvisitcount();
	}

	@Override
	public int womanvisitcount() {
		return mapper.womanvisitcount();
	}

	@Override
	public List<UserDto> alluserlist() {
		return mapper.alluserlist();
	}

	@Override
	public boolean deleteuser(String userid) {
		if (0 < mapper.deleteuser(userid))
			return true;
		return false;
	}

}
