package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.NewsDto;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.service.AptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api("apt 컨트롤러 API V1")
@RequestMapping("/apt")
public class AptController {

	@Autowired
	AptService service;
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@ApiOperation(value = "dong 에 맞는 아파트리스트 반환, 실패시 FAIL 반환", response = HouseInfoDto.class)
	@PostMapping(value = "/dong")
	public ResponseEntity<?> aptdonglist(@RequestBody String dong) throws Exception {
		List<HouseInfoDto> list =service.aptdonglist(dong);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "aptname 에 맞는 아파트리스트 반환, 실패시 FAIL 반환", response = HouseInfoDto.class)
	@PostMapping(value = "/name")
	public ResponseEntity<?> aptnamelist(@RequestBody String aptname) throws Exception {
		List<HouseInfoDto> list =service.aptnamelist(aptname);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "아파트상위 5개 반환, 실패시 FAIL 반환", response = HouseInfoDto.class)
	@GetMapping(value = "/toplist")
	public ResponseEntity<?> topaptlist() throws Exception {
		List<HouseInfoDto> list =service.topaptlist();
		
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "뉴스 5개 반환, 실패시 FAIL 반환", response = NewsDto.class)
	@GetMapping(value = "/news")
	public ResponseEntity<?> newslist() throws Exception {
		List<NewsDto> list =service.newslist();
		
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<NewsDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
}
