package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.service.AdminService;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api("user 컨트롤러 API V1")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	AdminService adminservice;
	
	@Autowired
	JwtService jwtservice;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@ApiOperation(value = "userid, userpwd 를 받아서 access-token, SUCCESS 메세지 반환, 실패시 FAIL 반환", response = Map.class)
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> map) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		UserDto user = service.login(map);
		HttpStatus status = null;
		
		if(user.getUserid() != null){
			adminservice.visituser(user.getUserid());
			String token =jwtservice.create("user", user, "access-token");
			resultMap.put("access-token", token);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} else {
			resultMap.put("message", FAIL);
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "userid, username 를 받아서 userpwd string 반환//json 아님 주의, 실패시 FAIL 반환", response = String.class)
	@PostMapping(value = "/searchpwd")
	public ResponseEntity<?> searchpwd(@RequestBody Map<String, String> map) throws Exception {
		String userpwd = service.searchpwd(map);
		if(userpwd != null) {
			return new ResponseEntity<String>(userpwd, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "UserDto를 받아서 정보 등록 성공시 SUCCESS 반환, 실패시 FAIL 반환", response = String.class)
	@PostMapping(value = "/")
	public ResponseEntity<?> register(@RequestBody UserDto user) throws Exception {
		if(service.register(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@ApiOperation(value = "access-token을 받아서 userdto 반환, 실패시 FAIL 반환", response = UserDto.class)
	@GetMapping(value = "/detail")
	public ResponseEntity<?> getuser() throws Exception {
		UserDto user = null;
		try {
			user = jwtservice.getUserDto();
		}catch (Exception e) {
			return new ResponseEntity(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value = "UserDto를 받아서 정보 수정 성공시 SUCCESS 반환, 실패시 FAIL 반환", response = String.class)
	@PutMapping(value = "/update")
	public ResponseEntity<?> modify(@RequestBody UserDto user) throws Exception {
		if(service.modifyuser(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@ApiOperation(value = "access-token을 받아서 정보 삭제 성공시 SUCCESS 반환, 실패시 FAIL 반환", response = String.class)
	@DeleteMapping(value = "/")
	public ResponseEntity<?> delete() throws Exception {
		UserDto user = null;
		try {
			user = jwtservice.getUserDto();
		}catch (Exception e) {
			return new ResponseEntity(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(service.deleteuser(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@ApiOperation(value = "access-token을 받아서 유저 즐겨찾기 리스트 반환, 실패시 FAIL 반환", response = String.class)
	@PostMapping(value = "/favorite")
	public ResponseEntity<?> userfavorite() throws Exception {
		UserDto user = null;
		try {
			user = jwtservice.getUserDto();
		}catch (Exception e) {
			return new ResponseEntity(FAIL, HttpStatus.NOT_ACCEPTABLE);
		}

		String userid = user.getUserid();
		List<HouseInfoDto> list = service.userfavorite(userid);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
}
