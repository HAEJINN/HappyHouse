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
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@ApiOperation(value = "dashboard 값 한번에 반환, 실패시 FAIL 반환", response = UserDto.class)
	@GetMapping(value = "/static")
	public ResponseEntity<?> dashboardstatic() throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("todayvisituser", adminservice.todayvisiter());
		map.put("monthvisituser", adminservice.monthvisiter());
		map.put("manvisitcount", adminservice.manvisitcount());
		map.put("womanvisitcount", adminservice.womanvisitcount());
		
		if(map.size() >= 4){
			return new ResponseEntity<Map<String, Integer>>(map, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "notice board list 반환, 실패시 FAIL 반환", response = List.class)
	@GetMapping(value = {"/board", "/board/{boardnum}"})
	public ResponseEntity<?> boardlist(@PathVariable(value = "boardnum", required = false) String boardnum) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardnum", boardnum);
		map.put("boardtype", "notice");
		List<BoardDto> list = boardservice.search(map);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
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
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "notice board접근 추가 , 실패시 FAIL 반환", response = String.class)
	@PostMapping(value = "/board")
	public ResponseEntity<?> registboard(@RequestBody Map<String, String> map) throws Exception {
		map.put("boardtype", "notice");
		
		if(boardservice.registboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "notice board접근 수정, 실패시 FAIL 반환", response = String.class)
	@PutMapping(value = "/board")
	public ResponseEntity<?> modifyboard(@RequestBody Map<String, String> map) throws Exception {
		map.put("boardtype", "notice");
		
		if(boardservice.modifyboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "notice board접근 삭제, 실패시 FAIL 반환", response = String.class)
	@DeleteMapping(value = "/board")
	public ResponseEntity<?> deleteboard(@RequestBody Map<String, String> map) throws Exception {
		map.put("boardtype", "notice");
		
		if(boardservice.deleteboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
}
