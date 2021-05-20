package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api("admin 컨트롤러 API V1")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@ApiOperation(value = "dashboard 값 한번에 반환, 실패시 FAIL 반환", response = UserDto.class)
	@GetMapping(value = "/static")
	public ResponseEntity<?> dashboardstatic() throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("todayvisituser", service.todayvisiter());
		map.put("monthvisituser", service.monthvisiter());
		map.put("manvisitcount", service.manvisitcount());
		map.put("womanvisitcount", service.womanvisitcount());
		
		if(map.size() >= 4){
			return new ResponseEntity<Map<String, Integer>>(map, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
}
