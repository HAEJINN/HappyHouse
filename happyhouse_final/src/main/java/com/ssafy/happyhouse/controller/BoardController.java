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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api("board 컨트롤러 API V1")
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	final String SUCCESS = "SUCCESS";
	final String FAIL = "FAIL";
	
	@ApiOperation(value = "post board list 반환, 실패시 FAIL 반환", response = List.class)
	@GetMapping(value = {"/", "/{boardid}"})
	public ResponseEntity<?> boardlist(@PathVariable(value = "boardid", required = false) String boardid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardnum", boardid);
		map.put("boardtype", "post");
		List<BoardDto> list = service.search(map);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "post board detail 반환, 실패시 FAIL 반환", response = BoardDto.class)
	@GetMapping(value = {"/detail/{boardid}"})
	public ResponseEntity<?> detailboard(@PathVariable(value = "boardid", required = false) String boardid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardtype", "post");
		map.put("boardid", boardid);
		BoardDto board = service.detailboard(map);
		if(board != null) {
			return new ResponseEntity<BoardDto>(board, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "post board접근 추가 , 실패시 FAIL 반환", response = String.class)
	@PostMapping(value = "/")
	public ResponseEntity<?> registboard(@RequestBody Map<String, String> map) throws Exception {
		map.put("boardtype", "post");
		
		if(service.registboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "post board접근 수정, 실패시 FAIL 반환", response = String.class)
	@PutMapping(value = "/")
	public ResponseEntity<?> modifyboard(@RequestBody Map<String, String> map) throws Exception {
		map.put("boardtype", "post");
		
		if(service.modifyboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "post board접근 삭제, 실패시 FAIL 반환", response = String.class)
	@DeleteMapping(value = "/delete/{boardid}")
	public ResponseEntity<?> deleteboard(@PathVariable(value = "boardid") String boardid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardid", boardid);
		map.put("boardtype", "post");
		System.out.println(map);
		if(service.deleteboard(map)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity(FAIL, HttpStatus.NOT_FOUND);
		}
	}
}
