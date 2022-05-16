package com.study.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.myapp.dto.BoardDTO;
import com.study.myapp.service.BoardService;

public class BoardMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		BoardService service = (BoardService)ctx.getBean("service");
		
		// 게시글 등록
//		BoardDTO insertDTO = new BoardDTO();
//		insertDTO.setTitle("myBatis Test");
//		insertDTO.setContent("Test MyBatis");
//		insertDTO.setWriter("Google");
//		System.out.println(service.boardInsert(insertDTO)? "Success Insert" : "Fail Insert");
		
		// 게시글 수정
//		BoardDTO updateDTO = new BoardDTO();
//		updateDTO.setBno(1);
//		updateDTO.setTitle("I'm Full");
//		updateDTO.setContent("Please Give me rest Time");
//		System.out.println(service.boardUpdate(updateDTO)? "Success Update" : "Fail Update");

		// 게시글 삭제
//		System.out.println(service.boardDelete(1)? "Success Delete" : "Fail Delete");
		
		
		// 게시글 목록
//		List<BoardDTO> list = service.boardSelect();
//		
//		for(BoardDTO dto : list) {
//			System.out.println(dto);
//		}
		
		// 게시글 조회
		System.out.println(service.getRow(5));
		
	}
}
