package com.study.controller;

/*
	Spring Security
		1 . 인증 및 접근제한 프레임워크
		2 . 암호화 기능 제공
		3 . Spring 기반 Application 보안을 위한 표준
		4 . Session 변조, Clickjacking, CSRF 와 관련딘 웹 보안 기능 제공
	
	Servlet Container ( TomCat )
	
	1 . request 가 threadlocal 로 실행되어 들어옴
	
		filter 1 , 2 , 3 ...
		
		DelegatingFilterProxy : Security 와 관련된 모든 Filter 를 관리·대행
	
	2 . Filter 를 순서대로 거친 후
	
	3 . DispatcherServlet 을 통해 각 Url 에 맞는 Controller 로 분기
	
	4 . 실행될 메소드를 찾아 request, response 를 넘겨준다
	
	Modules 
		1 . Spring Security Core
			
		2 . Spring Security Web
	
		3 . Spring Security Config
	
		4 . Spring Security Taglibs
	
	Spring Web Security
		
		1 . Filter 설정 ( DelegatingFilterProxy )
			- 기본 login / logout 페이지 제공 ( 커스텀 로그인 페이지 ( security-context.xml 에서 지정 )
	
			§ Custom Login Page 규칙
				1 ) form 태그의 Action 은 "/login" 으로 작성한다.
				2 ) input 태그의 name 을 "username / password" 로 작성한다.
				3 ) post 방식으로 가능 form 은 CSRF 토근 값을 반드시 포함해야한다.
	
	Spring Security
		1 . 인증 ( Authentication )
			- 본인 인증
			- 대상자 스스로 자신을 증명할 자료를 제시
		2 . 권한 ( Authorization )
	
	접근제한 방법
		1 ) 설정 파일에서 intercept-url 이용
		2 ) Controller에서 제한
		
	CSRF(cross-site request forgery) 공격
		공격자는 사이트(Web Server)가 신회하는 사용자를 통해 공격자가 원하는 명령을 대신 실행하게 함
			=> 서버에서 받아들이는 요청을 해석하고 처리할 때 어떤 출처에서 호출이 진행되었는지 따지지 않기 때문에 생기는 허점을 노리는 공격 방식
	
		1 . CSRF 스크립트가 포함된 게시물 등록 ( Attacker )
		2 . CSRF 스크립트가 포함된 게시물 열람 ( User )
		3 . CSRF 스크립트가 포함된 게시물 응답 ( Attacker )
		4 . CSRF 스크립트 실행 (사용자 권한)
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SecurityController {
	
	@GetMapping("/login")
	public void login() {
		log.info("[GET] <<<<< login Page >>>>> ");
	}
	
	@GetMapping("/user-page")
	public String userPage() {
		log.info("[GET] <<<<< User Page >>>>> ");
		return "userpage";
	}

	@GetMapping("/admin-page")
	public String adminPage() {
		log.info("[GET] <<<<< Admin Page >>>>> ");
		return "adminpage";
	}
	
	@PostMapping("/login-error")
	public String loginError(Model model) {
		log.info("[Error-Page] <<<<< Login Error >>>>> ");
		model.addAttribute("loginError", "아이디 또는 비밀번호를 확인해주세요");
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		log.info("[Error-Page] <<<<< Access Denied >>>>> ");
		return "accessdenied";
	}
	
}
