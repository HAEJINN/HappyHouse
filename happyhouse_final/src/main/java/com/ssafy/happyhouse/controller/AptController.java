package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.service.AptService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@Api("apt 컨트롤러 API V1")
@RequestMapping("/apt")
public class AptController {

	@Autowired
	AptService service;
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@PostMapping(value = "/list")
	public ResponseEntity<?> getaptlist(@RequestBody String dong) throws Exception {
		List<HouseInfoDto> list =service.houseinfolist(dong);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
