package com.study.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.RegisterDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@GetMapping("/doB")
	public String doB(RedirectAttributes rttr) {
		/*
			redirect 페이지 이동시 값 전달 방법
				① RedirectAttributes.addAttribute("name", val) : URL 에 "name=val" 을 추가해 페이지 이동
					ex) http://localhost:9090/?age=10
				② RedirectAttributes.addFlashAttribute("name", val) : Session 에 값을 담아 전달 ( 1회성 - refresh 해도 Session 값이 사라짐 )
		*/
		rttr.addAttribute("age", 10); // URL O
		rttr.addFlashAttribute("num", "15"); // URL X
		return "redirect:/";
	}
	
	// 예전 방식
	@GetMapping("/doC")
	public ModelAndView doC() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home"); // 페이지 ( log : o.s.web.servlet.view.JstlView - View name 'home', model {} )
		mav.addObject("num", 35); // 값 지정 ( request.setAttribute() )
		return mav;
	}
	
	// 후에 , RestController 를 통해 활용 가능 ( 현재 X ) 
//	@GetMapping("/doD")
//	public RegisterDTO regist() {
//		return new RegisterDTO();
//	}
}
