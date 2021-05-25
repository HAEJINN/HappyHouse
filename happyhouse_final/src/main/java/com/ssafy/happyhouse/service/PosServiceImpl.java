package com.ssafy.happyhouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.PosDto;
import com.ssafy.happyhouse.model.mapper.PosMapper;
import com.ssafy.happyhouse.util.util;

@Service
public class PosServiceImpl implements PosService {

	@Autowired
	PosMapper mapper;

	@Override
	public List<PosDto> convenlist(PosDto midpos) {
		List<PosDto> list = mapper.convenlist();
		List<PosDto> resultlist = new ArrayList<PosDto>();
		for (PosDto pos : list) {
			if (1 >= util.distanceInKilometerByHaversine(midpos, pos)) {
				resultlist.add(pos);
			}
		}
		return resultlist;
	}

	@Override
	public List<PosDto> cctvlist(PosDto midpos) {
		List<PosDto> list = mapper.cctvlist();
		List<PosDto> resultlist = new ArrayList<PosDto>();
		for (PosDto pos : list) {
			if (1 >= util.distanceInKilometerByHaversine(midpos, pos)) {
				resultlist.add(pos);
			}
		}
		return resultlist;
	}

	@Override
	public List<PosDto> cafelist(PosDto midpos) {
		List<PosDto> list = mapper.cafelist();
		List<PosDto> resultlist = new ArrayList<PosDto>();
		for (PosDto pos : list) {
			if (1 >= util.distanceInKilometerByHaversine(midpos, pos)) {
				resultlist.add(pos);
			}
		}
		return resultlist;
	}

	@Override
	public List<PosDto> pharlist(PosDto midpos) {
		List<PosDto> list = mapper.pharlist();
		List<PosDto> resultlist = new ArrayList<PosDto>();
		for (PosDto pos : list) {
			if (1 >= util.distanceInKilometerByHaversine(midpos, pos)) {
				resultlist.add(pos);
			}
		}
		return resultlist;
	}

	@Override
	public List<PosDto> buslist(PosDto midpos) {
		List<PosDto> list = mapper.buslist();
		List<PosDto> resultlist = new ArrayList<PosDto>();
		for (PosDto pos : list) {
			if (1 >= util.distanceInKilometerByHaversine(midpos, pos)) {
				resultlist.add(pos);
			}
		}
		return resultlist;
	}

	@Override
	public List<PosDto> trainlist(PosDto midpos) {
		List<PosDto> list = mapper.trainlist();
		List<PosDto> resultlist = new ArrayList<PosDto>();
		for (PosDto pos : list) {
			if (1 >= util.distanceInKilometerByHaversine(midpos, pos)) {
				resultlist.add(pos);
			}
		}
		return resultlist;
	}

}
