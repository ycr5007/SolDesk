package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.NumDTO;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/calc/*")
@Slf4j
@Controller
public class AddController {
	
	@GetMapping("/add")
	public void add() {
		log.info("[GET] add 호출 ");
	}
	
//	@PostMapping("/add")
//	public void add(@RequestParam("num1") int x, @RequestParam("num2") int y, Model model) {
//		log.info("[POST] add 호출 ");
//		model.addAttribute("result", x + y);
//	}

	// input Tag에 입력값 없이 전송한 경우
		// 400 Error : 클라이언트 오류로서 인지된 어떤 문제로 인하여, 서버가 해당 요청을 처리할 수 없거나, 처리하지 않을 것입니다. (예: 잘못된 요청 문법, 유효하지 않은 요청 메시지 framing, 또는 신뢰할 수 없는 요청 라우팅).
	
//	@PostMapping("/add")
//	public void add(int num1, int num2, Model model) {
//		log.info("[POST] add 호출 ");
//		model.addAttribute("result", num1 + num2);
//	}
	
//	@PostMapping("/add")
//	public void add(@RequestParam(value = "num1", required = true, defaultValue = "0") int num1, @RequestParam(value = "num2", required = false, defaultValue = "0") int num2, Model model) {
//		log.info("[POST] add 호출 ");
//		model.addAttribute("result", num1 + num2);
//	}
	
	@PostMapping("/add")
	public void add(NumDTO numDto, Model model) {
		log.info("[POST] add 호출 ");
		model.addAttribute("result", numDto.getNum1() + numDto.getNum2());
	}

//	@PostMapping("/add")
//	public void add(@ModelAttribute("dto") NumDTO numDto) {
//		log.info("[POST] add 호출 ");
//	}
	
	/* 	
		바인딩객체 ( DTO 형태로 값을 받아오는 객체 )
			DTO 객체 형태로 받을 경우, jsp 에서 DTO 객체를 사용할 수 있도록 값을 유지시킨다.
				JSP 사용 	: EL ( 영역속성(request·session)에 담은 값을 찾아서 쓸 수 있게 해준다 )
						: EL 사용 시 "name" 값은, 자동생성 된 이름으로 적용 ( 클래스 이름의 가장 앞 글자를 소문자로 변경 하여 사용 : ex ) numDTO )
						: DTO 객체 내 멤버변수 적용, ex ) numDTO.num1
						
			변수를 매개변수로 받는 경우 : JSP 값 유지 X
			바인딩객체 ( DTO ) 로 받는 경우 : JSP 값 유지 O
	*/
	
	
	/*
		@RequestParam
			value = "form Tag name"
			required = [true|false]
				true : 값이 없을 경우 400 Error 발생
			defaultValue = "default"
			
		@ModelAttribute("name") : 바인딩 객체의 이름 설정
		
		Model 객체 : 값 전달을 위한 객체 ( request.setAttribute() ) 
			Model.addAttribute("name", value)
			
	*/
	
}
