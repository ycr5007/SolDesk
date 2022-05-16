package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.SpUser;
import com.study.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/member/*")
@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public  void register() {
		log.info("[GET] <<<<< Register Form >>>>> ");
	}

	@PostMapping
	public String register(SpUser user) {
		log.info("[POST] <<<<< Register >>>>> ");
		log.info("[POST] " + user);
		
		service.register(user);
		
		return "redirect:/login";
	}
}
