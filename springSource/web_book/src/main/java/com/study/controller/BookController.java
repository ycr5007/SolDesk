package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.dto.BookDTO;
import com.study.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/book/*")
@Slf4j
@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	// 전체 리스트 보여주기 ( list )
	@GetMapping("/list")
	public void list(Model model) {
		log.info("[GET] 도서 전체 목록");
		
		// 서비스 호출
		List<BookDTO> list = service.getList();
		
		// 리스트 담기
		model.addAttribute("list", list);
	}
	
	// 도서 입력 폼 보여주기
	@GetMapping("/insert")
	public void insertBook() {
		log.info("[GET] 도서 입력");
	}
	
	@PostMapping("/insert")
	public String insertBook(BookDTO insertDto, RedirectAttributes rttr) {
		log.info("[POST] 도서 입력");
		try {
			if(service.insert(insertDto)) {
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			return "redirect:/book/insert";
		}
		return "redirect:/book/insert";
	}
	
	// 도서 삭제 폼 보여주기
	@GetMapping("/delete")
	public void deleteBook() {
		log.info("[GET] 도서 삭제");
	}
	
	@PostMapping("/delete")
	public String deleteBook(int code) {
		log.info("[POST] 도서 삭제");
		try {
			if(service.delete(code)) {
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			return "/book/delete";
		}
		return "/book/delete";
	}
	
	// 도서 수정 폼 보여주기
	@GetMapping("/update")
	public void updateBook() {
		log.info("[GET] 도서 수정");
	}
	
	@PostMapping("/update")
	public String updateBook(int code, int price) {
		log.info("[POST] 도서 수정");
		try {
			if(service.update(code, price)) {
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			return "/book/update";
		}
		
		return "/book/update";
	}
	
	// 도서 검색 폼 보여주기
	@GetMapping("/search")
	public void searchBook() {
		log.info("[GET] 도서 검색");
	}
	
	@PostMapping("/search")
	public String searchBook(String criteria, String keyword, Model model) {
		log.info("[POST] 도서 검색");
		
		List<BookDTO> list = service.searchList(criteria, keyword);
		model.addAttribute("list", list);
		return "/book/list";
	}
	
	
}
