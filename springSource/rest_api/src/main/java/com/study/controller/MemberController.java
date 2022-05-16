package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.dto.ChangeDTO;
import com.study.dto.MemberDTO;
import com.study.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // Controller 가 보내는 모든 값은 데이터임을 명시
@RequestMapping("/member/*")
public class MemberController {
	
	@Qualifier("memberService")
	@Autowired
	private MemberService service;
	
	
	// /member/new + POST + body(JSON data)
	@PostMapping("/new")
	public ResponseEntity<String> insert(@RequestBody MemberDTO register){
		log.info("[POST] 회원가입 요청");
		
		return service.register(register) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	
	// /member/id + PUT + 수정데이터(JSON data)
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable("id") String userid, @RequestBody ChangeDTO change){
		log.info("[PUT] 비밀번호 수정 요청");
		return service.changePassword(change) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
}
