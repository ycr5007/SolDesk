package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.RegisterDTO;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/member/*")
@Slf4j
@Controller
public class RegisterController {
	
	@GetMapping("/register")
	public void register() {
		log.info("[GET] Register Form");
	}

	@PostMapping("/register")
	public String register(RegisterDTO dto) {
		log.info("[POST] Submit Register");
//		return "sample/login"; // Forwarding
		return "redirect:/login"; // sendRedirect
	}
}
