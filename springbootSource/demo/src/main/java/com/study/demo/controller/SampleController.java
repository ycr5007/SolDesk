package com.study.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	
	@ResponseBody
	@GetMapping("/hello")
	public String[] hello() {
		log.info("[GET] <<<<< HELLO >>>>>");
		return new String[] {"Good Bye", "Spring FrameWork"};
	}
	
	@GetMapping("/")
	public String home() {
		log.info("[GET] <<<<< INDEX 요청 >>>>>");
		return "index";
	}
	
	@GetMapping("/sub/test2")
	public void test() {
		log.info("[GET] <<<<< TEST >>>>>");
	}
	
}
