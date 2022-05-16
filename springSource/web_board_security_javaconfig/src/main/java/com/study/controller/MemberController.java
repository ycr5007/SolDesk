package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@GetMapping("/login")
	public void loginForm() {
		log.info("[GET] <<<<< Login Form >>>>> ");
	}
	
	@PostMapping("/login-error")
	public String loginError(Model model) {
		log.info("[Error-Page] <<<<< Login Error >>>>> ");
		model.addAttribute("loginError", "아이디 또는 비밀번호를 확인해주세요");
		return "/member/login";
	}
	
	@GetMapping("/admin-page")
	public String adminPage() {
		log.info("[GET] <<<<< Admin Page >>>>> ");
		return "adminpage";
	}
	
}
