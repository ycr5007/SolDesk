package com.study.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.myapp.dto.BookDTO;
import com.study.myapp.service.BookService;

public class BookMain {
	public static void main(String[] args) {
		
//		순수 자바코드 
//		BookService service = new BookServiceImpl();
//		List<BookDTO> list = service.getList();

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		// service 객체 생성
		BookService service = (BookService) ctx.getBean("service");
		
		
		// 도서정보 삽입
//		BookDTO insertDTO = new BookDTO(2007, "톰소여의 모험", "마크트웨인", 18000);
//		System.out.println(service.bookInsert(insertDTO)?"Success Insert" : "Fail Insert");
		
		// 도서정보 수정
//		System.out.println(service.bookUpdate(2005, 41000)?"Success Update" : "Fail Update");
		
		// 도서정보 삭제
//		System.out.println(service.bookDelete(1003)?"Success Delete" : "Fail Delete");
		
		// 도서정보 조회
//		List<BookDTO> list = service.getList();
		
		// 도서정보 검색
		List<BookDTO> list = service.searchList("writer", "남궁성");
		
		for(BookDTO dto : list) {
			System.out.println(dto);
		}
		
	}
}
