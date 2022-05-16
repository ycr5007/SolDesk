package com.study.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/sample/*") 
public class SampleController {
	/*
		404 Error
			Message O : .jsp 페이지 없음 ( Controller 은 있으나, jsp 파일 X )
				View Resolver 가 실행되며, prefix ( /WEB-INF/views/ ), suffix ( .jsp ) 가 이어져 /WEB-INF/views/sample/basic.jsp 호출 ) 
			Message X : Controller 없음
	 */

	
	// Controller 의 return 타입이 void 인 경우 >> http://localhost:9090/ 다음 부분이 jsp 페이지를 찾는데 사용 ( /sample/basic )
//	@RequestMapping(path="/basic", method=RequestMethod.GET) 
//	@GetMapping("/basic")
//	public void basic(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
//		log.info("basic..."); // jsp 파일 검색 경로 : [/WEB-INF/views/sample/basic.jsp]
//		model.addAttribute("page", page);
//	}
	
	@GetMapping("/basic")
	public void basic(@ModelAttribute("page") int page) {
		log.info("basic..."); // jsp 파일 검색 경로 : [/WEB-INF/views/sample/basic.jsp]
	}
	
//	@RequestMapping(path="/login", method=RequestMethod.GET)
	@GetMapping("/login")
	public void login() {
		log.info("login...");
	}

	/*
		Controller Parameter 수집
			① 변수명 사용 ( form 태그 name 값 = 매개변수 변수명 )
			② ~DTO 객체 사용 ( form 태그 name 값 = DTO 객체 멤버 변수명 )
			③ HttpServletRequest 객체 사용 ( request.getParameter ) : int 자동 형변환 X
			
			> int 형변환 없이 자동으로 처리 가능 ( int 형의 경우, 문자열 입력시 400 에러 발생 ) 
				> HTTP 상태 400 – 잘못된 요청
				> 클라이언트 오류로서 인지된 어떤 문제로 인하여, 서버가 해당 요청을 처리할 수 없거나, 처리하지 않을 것입니다. 
				> (예: 잘못된 요청 문법, 유효하지 않은 요청 메시지 framing, 또는 신뢰할 수 없는 요청 라우팅).
				
			Annotation
				@RequestParam("name") : Parameter 로 사용된 변수의 이름과 전달되는 Parameter 의 이름이 다른 경우 사용
	*/
	
//	@RequestMapping(path="/login", method=RequestMethod.POST)
//	@PostMapping("/login")
//	public void loginPost(String userid, String password, String addr, int age) { // form 태그로부터 넘어오는 값 (name 일치 할 때 값 불러옴)
//		log.info("[POST] login " + userid + " / " + password + " / " + addr + " / " + age);
//	}
	
//	@PostMapping("/login")
//	public void loginPost(SampleDTO dto) {
//		log.info("[POST] login " + dto.getUserid() + " / " + dto.getPassword() + " / " + dto.getAddr() + " / " + dto.getAge());
//	}
	
	@PostMapping("/login")
	public void loginPost(HttpServletRequest request) { // form 태그로부터 넘어오는 값 (name 일치 할 때 값 불러옴)
		log.info("[POST] login " + request.getParameter("userid") + " / " + request.getParameter("password") + " / " + request.getParameter("addr") + " / " + Integer.parseInt(request.getParameter("age")));
	}
	
//	@RequestMapping(path="/doA", method=RequestMethod.GET)
	@GetMapping("/doA")
	public void doA(String userid) {
		log.info("[GET] doA " + userid); // ( http://localhost:9090/sample/doA?userid=abc ) QueryString 통해서 변수 전달 가능
	}
	
	// return String 의 경우, Mapping 한 URL 이 아닌 반환한 String 값이 입력된다 ( [/WEB-INF/views/select.jsp] !! ) /sample/select.jsp 아님 ) 
	// value ( 이전 버전 - 사용은 가능 ) = path 
//	@RequestMapping(value="/insert", method=RequestMethod.GET)
	@GetMapping("/insert")
	public String insert(@RequestParam("ids") ArrayList<String> ids) { // ArrayList 를 Parameter 로 받기위한 Annotation ( @RequestParam("ids") )
		log.info("[GET]insert " + ids); // jsp 파일 검색 경로 : [/WEB-INF/views/insert.jsp]
		return "insert"; 
	}
	
	/*
		@RequestMapping("Path") : GET / POST 방식 모두 허용
		@RequestMapping(path="Path", method=RequestMethod.GET) : GET 방식만 허용
			> POST 방식 전송 시 : 405 Error 허용되지 않는 메소드
	*/
	
	/*
		java.lang.IllegalStateException: Ambiguous mapping > 같은 위치로 Mapping 해주는 Controller 가 존재하는 경우 (Method / URL 둘 다 같은 경우)
	*/
}
