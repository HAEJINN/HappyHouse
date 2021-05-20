package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.service.BassAddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api("BaseAddress 컨트롤러 API V1")
@RequestMapping("/base")
public class BaseAddressController {

	@Autowired
	BassAddressService service;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@ApiOperation(value = "시,도 리스트를 반환한다.", response = List.class)
	@GetMapping(value = "/city")
	public ResponseEntity<List<String>> getcity() throws Exception {
		List<String> list = service.getcity();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "city를 받아서, 구군 리스트를 반환한다.", response = List.class)
	@PostMapping(value = "/gugun")
	public ResponseEntity<List<String>> getgugun(@RequestBody Map<String, String> map) throws Exception {
		System.out.println("test");
		System.out.println(map);
		List<String> list = service.getgugun(map);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "city, gugun을 받아서, 동 리스트를 반환한다.", response = List.class)
	@PostMapping(value = "/dong")
	public ResponseEntity<List<String>> getdong(@RequestBody Map<String, String> map) throws Exception {
		List<String> list = service.getdong(map);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}