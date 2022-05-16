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
//		BookDTO insertDTO = new BookDTO(2005, "코스모스", "칼 세이건", 35000);
//		System.out.println(service.bookInsert(insertDTO)?"Success Insert" : "Fail Insert");
		
		// 도서정보 수정
//		System.out.println(service.bookUpdate(2005, 41000)?"Success Update" : "Fail Update");
		
		// 도서정보 삭제
		System.out.println(service.bookDelete(1003)?"Success Delete" : "Fail Delete");
		
		// 도서정보 조회
		List<BookDTO> list = service.getList();
		
		for(BookDTO dto : list) {
			System.out.println(dto);
		}
		
	}
}
