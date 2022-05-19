package com.study.thymeleaf.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.thymeleaf.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/sample") // templates 의 폴더 경로와 일치시킴
@Controller
public class SampleController {
	
	@GetMapping("/ex1") // html 파일의 이름과 일치시킴
	public void ex1(Model model) {
		log.info("[GET] <<<<< ex1 >>>>>");
		model.addAttribute("data", "thymeLeaf");
	}

	@GetMapping("/ex2")
	public void ex2(Model model) {
		log.info("[GET] <<<<< ex2 >>>>>");
		model.addAttribute("greeting", "Bye ThymeLeaf");
	}

	@GetMapping("/ex3")
	public void ex3(Model model) {
		log.info("[GET] <<<<< ex3 >>>>>");
		MemberDTO dto = new MemberDTO();
		dto.setMno(1);
		dto.setMid("bula--m");
		dto.setMpw("bulam123123");
		dto.setMname("최불암");
		dto.setRegdate(new Timestamp(System.currentTimeMillis()));
		model.addAttribute("dto", dto);
	}

	@GetMapping("/ex4")
	public void ex4(Model model) {
		log.info("[GET] <<<<< ex4 >>>>>");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		for(int i = 0; i < 11; i++) {
			MemberDTO dto = new MemberDTO(i, "bula--m" + i, "bulam" + i, i + "번 최불암", new Timestamp(System.currentTimeMillis()));
			list.add(dto);
		}
		model.addAttribute("list", list);
	}

	@GetMapping("/ex5")
	public void ex5(Model model) {
		log.info("[GET] <<<<< ex5 >>>>>");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		for(int i = 0; i < 10; i++) {
			MemberDTO dto = new MemberDTO(i, "a---m" + i % 3, "am" + i % 3, i + "번 암", new Timestamp(System.currentTimeMillis()));
			list.add(dto);
		}
		model.addAttribute("list", list);
	}
	
	@GetMapping("/ex6")
	public void ex6(Model model) {
		log.info("[GET] <<<<< ex6 >>>>>");
		String result = "SUCCESS";
		
		model.addAttribute("result", result);
	}
	
	@GetMapping("/ex-inline")
	public String exInLine(RedirectAttributes rttr) {
		log.info("[GET] <<<<< exInLine >>>>>");
		MemberDTO dto = new MemberDTO();
		dto.setMno(1);
		dto.setMid("bula--m");
		dto.setMpw("bulam123123");
		dto.setMname("최불암");
		dto.setRegdate(new Timestamp(System.currentTimeMillis()));
		
		rttr.addFlashAttribute("dto", dto);
		rttr.addFlashAttribute("result", "SUCCESS");
		return "redirect:/sample/ex7";
	}
	
	@GetMapping({"/ex7", "/exlink"})
	public void ex7() {
		log.info("[GET] <<<<< ex7 || exlink >>>>>");
	}

	@GetMapping("/ex8")
	public void ex8(String param1, String param2, Model model) {
		log.info("[GET] <<<<< ex8 >>>>>");
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
	}

	@GetMapping("/exLayout1")
	public void exLayout1() {
		log.info("[GET] <<<<< exLayout1 >>>>>");
	}

	@GetMapping("/exLayout2")
	public void exLayout2() {
		log.info("[GET] <<<<< exLayout2 >>>>>");
	}

	@GetMapping("/exLayout3")
	public void exLayout3() {
		log.info("[GET] <<<<< exLayout3 >>>>>");
	}

	@GetMapping("/exTemplate1")
	public void exTemplate1() {
		log.info("[GET] <<<<< exTemplate1 >>>>>");
	}

	@GetMapping("/exSidebar")
	public void exSidebar() {
		log.info("[GET] <<<<< exSidebar >>>>>");
	}
}
