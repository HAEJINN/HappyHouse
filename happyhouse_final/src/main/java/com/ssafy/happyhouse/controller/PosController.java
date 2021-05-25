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

import com.ssafy.happyhouse.model.PosDto;
import com.ssafy.happyhouse.service.PosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api("pos 컨트롤러 API V1")
@RequestMapping("/pos")
public class PosController {

	@Autowired
	PosService service;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@ApiOperation(value = "중심좌표 받음, 1km 이내 cctv좌표 list 반환, 실패시 FAIL 반환", response = List.class)
	@PostMapping(value = "/cctv")
	public ResponseEntity<?> cctvlist(@RequestBody PosDto pos) throws Exception {
		List<PosDto> list = service.cctvlist(pos);
		
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PosDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "중심좌표 받음, 1km 이내 편의점좌표 list 반환, 실패시 FAIL 반환", response = List.class)
	@PostMapping(value = "/conven")
	public ResponseEntity<?> convenlist(@RequestBody PosDto pos) throws Exception {
		List<PosDto> list = service.convenlist(pos);
		
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PosDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "중심좌표 받음, 1km 이내 카페좌표 list 반환, 실패시 FAIL 반환", response = List.class)
	@PostMapping(value = "/cafe")
	public ResponseEntity<?> cafelist(@RequestBody PosDto pos) throws Exception {
		List<PosDto> list = service.cafelist(pos);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PosDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "중심좌표 받음, 1km 이내 약국좌표 list 반환, 실패시 FAIL 반환", response = List.class)
	@PostMapping(value = "/phar")
	public ResponseEntity<?> pharlist(@RequestBody PosDto pos) throws Exception {
		List<PosDto> list = service.pharlist(pos);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PosDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
}
