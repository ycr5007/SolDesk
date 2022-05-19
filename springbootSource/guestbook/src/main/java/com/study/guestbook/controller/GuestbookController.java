package com.study.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.guestbook.dto.GuestbookDTO;
import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.service.GuestbookService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/guestbook")
@Slf4j
@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService service;
	
	@GetMapping({"/", "/list"})
	public String list(PageRequestDTO requestDto, Model model) {
		log.info("[GET] <<<<< INDEX 요청 >>>>>");
		log.info("[PageRequest] " + requestDto);
		
		// List Model 로 값 전달
		model.addAttribute("result", service.getList(requestDto));
		
		return "/guestbook/list";
	}
	
	@GetMapping("/register")
	public void registerGet() {
		log.info("[GET] <<<<< REGISTER Page 요청 >>>>>");
	}
	
	@PostMapping("/register")
	public String register(GuestbookDTO insertDto, RedirectAttributes rttr) {
		log.info("[POST] <<<<< REGISTER Form 작업 >>>>>");
		log.info("[POST] GuestbookDTO : " + insertDto);
		Long gno = service.register(insertDto);
		if(gno > 0) {
			rttr.addFlashAttribute("msg", gno);
		}
		return "redirect:/guestbook/list";
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(Long gno, @ModelAttribute("page") PageRequestDTO page, Model model) {
		log.info("[GET] <<<<< READ | MODIFY 요청 >>>>>");
		log.info("[GET] gno : " + gno);
		log.info("[GET] PageRequestDTO : " + page);
		
		model.addAttribute("dto", service.getOne(gno));
	}
	
	@PostMapping("/remove")
	public String remove(Long gno, RedirectAttributes rttr) {
		log.info("[POST] <<<<< REMOVE Form 작업 >>>>>");
		log.info("[POST] gno : " + gno);
		service.remove(gno);
		
		rttr.addFlashAttribute("msg", gno);
		return "redirect:/guestbook/list";
	}
	
	
	@PostMapping("/modify")
	public String modify(GuestbookDTO updateDto, @ModelAttribute("page") PageRequestDTO page, RedirectAttributes rttr) {
		log.info("[POST] <<<<< MODIFY Form 작업 >>>>>");
		log.info("[POST] GuestbookDTO : " + updateDto);
		Long gno = service.modify(updateDto);
		if(gno > 0) {
			rttr.addFlashAttribute("msg", gno);
		}
		rttr.addAttribute("gno", gno);
		rttr.addAttribute("page", page.getPage());
		rttr.addAttribute("type", page.getType());
		rttr.addAttribute("keyword", page.getKeyword());
		return "redirect:/guestbook/read";
	}
	
}
