package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.dto.SampleDTO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Welcome home!");
		return "home";
	}
	
	@GetMapping("/member/step2")
	public void step2() {
		logger.info("[GET] 회원가입요청");
	}

	@GetMapping("/member/changePwd")
	public void change() {
		logger.info("[GET] 비밀번호 수정요청");
	}
	
	
	@ResponseBody // RestController 과 같은 효과 ( JSP 로 보내는 것(이동)이 아닌, 페이지에 표시 )
	@GetMapping("/test")
	public String read() {
		return "success";
	}
	
	@ResponseBody
	@GetMapping(path = "/dto_test", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleDTO modify() { 
		return new SampleDTO("1234", "park", "seoul");
	}
	
	@ResponseBody
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleDTO> list(){
		return new ResponseEntity<>(new SampleDTO("4321", "su", "busan"), HttpStatus.BAD_GATEWAY);
	}
}
