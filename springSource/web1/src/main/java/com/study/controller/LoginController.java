package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.dto.SampleDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String login() {
		log.info("[GET] login");
		return "sample/login";
	}
	
	
//	@PostMapping("/login")
//	public String loginPost(String userid, String password) {
//		log.info("[POST] login " + userid + " / " + password);
//		return "sample/login";
//	}
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute("user") SampleDTO dto) {
		log.info("[POST] login " + dto.getUserid() + " / " + dto.getPassword());
		return "sample/logout";
	}
	
//	@PostMapping("/login")
//	public String loginPost(HttpServletRequest request) {
//		log.info("[POST] login " + request.getParameter("userid") + " / " + request.getParameter("password"));
//		return "sample/login";
//	}
}
