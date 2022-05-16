package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*") // Get·PostMapping 사용 X ( RequestMapping 만 사용 가능 )
public class BoardController {
	
	@RequestMapping(path="/insert", method=RequestMethod.GET)
	public void insert() {
		log.info("[GET] insert ");
	}
//	@RequestMapping(path="/modify", method=RequestMethod.GET)
//	public void modify() {
//		log.info("[GET] modify ");
//	}
//	@GetMapping("/read")
//	public void read() {
//		log.info("[GET] read ");
//	}
	
	@GetMapping(path= {"/modify", "/read"})
	public void read() {
		log.info("[GET] read OR modify");
	}
	
	@GetMapping("/list")
	public String list() {
		log.info("[GET] list ");
//		return "redirect:/board/read"; -- redirect : 자기자신으로 움직이는 것 불가
		return "/board/list";
	}

	
}
