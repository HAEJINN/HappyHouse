package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.PosDto;

public interface PosService {
	List<PosDto> convenlist(PosDto midpos);

	List<PosDto> cctvlist(PosDto midpos);
}
