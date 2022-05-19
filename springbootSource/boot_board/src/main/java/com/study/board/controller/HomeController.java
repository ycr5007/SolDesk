package com.study.board.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/auth")
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
}

/*
	데이터베이스 설계
		1) 요구사항 분석 - 데이터베이스 용도 파악
		
		2) 개념적 설계 - 개체 추출, 속성 파악, 키 속성 선별, 개체 관계 결정 ( E-R 다이어그램 )
		
		3) 논리적 설계 - DBMS에 적합한 논리적 스키마 설계 ( 자료형, sequence 사용, default 값 ... )
		
		4) 물리적 설계 - SQL 작성
		
		5) 구현
		
	E-R Diagram
		관계
			1 : N 관계 >> 하나의 개체에 여러개 참조 가능
*/