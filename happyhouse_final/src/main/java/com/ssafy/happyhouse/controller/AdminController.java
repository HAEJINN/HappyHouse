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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.service.AdminService;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.JwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api("admin 컨트롤러 API V1")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@Autowired
	BoardService boardservice;
	
	@Autowired
	JwtService jwtservice;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@ApiOperation(value = "dashboard 값 한번에 반환, 실패시 FAIL 반환", response = UserDto.class)
	@GetMapping(value = "/static")
	public ResponseEntity<?> dashboardstatic() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("todayvisituser", adminservice.todayvisiter());
		map.put("weekvisiterlist", adminservice.weekvisiterlist());
		map.put("monthvisituser", adminservice.monthvisiter());
		map.put("manusercount", adminservice.manvisitcount());
		map.put("womanusercount", adminservice.womanvisitcount());
		
		if(map.size() >= 4){
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "notice board list 반환, 실패시 FAIL 반환", response = List.class)
	@GetMapping(value = {"/board", "/board/{boardid}"})
	public ResponseEntity<?> boardlist(@PathVariable(value = "boardid", required = false) String boardid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardnum", boardid);
		map.put("boardtype", "notice");
		List<BoardDto> list = boardservice.search(map);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "post board detail 반환, 실패시 FAIL 반환", response = BoardDto.class)
	@GetMapping(value = {"/board/detail/{boardid}"})
	public ResponseEntity<?> detailboard(@PathVariable(value = "boardid", required = false) String boardid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardtype", "notice");
		map.put("boardid", boardid);
		BoardDto board = boardservice.detailboard(map);
		if(board != null) {
			return new ResponseEntity<BoardDto>(board, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "notice board접근 추가 , 실패시 FAIL 반환", response = String.class)
	@PostMapping(value = "/board")
	public ResponseEntity<?> registboard(@RequestBody Map<String, String> map) throws Exception {
		map.put("boardtype", "notice");
		
		if(boardservice.registboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "notice board접근 수정, 실패시 FAIL 반환", response = String.class)
	@PutMapping(value = "/board")
	public ResponseEntity<?> modifyboard(@RequestBody Map<String, String> map) throws Exception {
		map.put("boardtype", "notice");
		
		if(boardservice.modifyboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "notice board접근 삭제, 실패시 FAIL 반환", response = String.class)
	@DeleteMapping(value = "/delete/{boardid}")
	public ResponseEntity<?> deleteboard(@PathVariable(value = "boardid") String boardid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardid", boardid);
		map.put("boardtype", "notice");
		
		if(boardservice.deleteboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "access-token을 받아서 admin 검사, admin 제외 user list 반환, 실패시 FAIL 반환", response = UserDto.class)
	@GetMapping(value = {"/user"})
	public ResponseEntity<?> alluserlist() throws Exception {
		
		if(jwtservice.getUserDto().getUserid().equals("admin")) {
			List<UserDto> list = adminservice.alluserlist();
			
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value = "access-token을 받아서 정보 삭제 성공시 SUCCESS 반환, 실패시 FAIL 반환", response = String.class)
	@DeleteMapping(value = "/user/{userid}")
	public ResponseEntity<?> delete(@PathVariable(value = "userid")String userid) throws Exception {
		if(jwtservice.getUserDto().getUserid().equals("admin") && adminservice.deleteuser(userid)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
