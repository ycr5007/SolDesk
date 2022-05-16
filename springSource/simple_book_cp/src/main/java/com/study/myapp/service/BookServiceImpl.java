package com.study.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myapp.dao.BookDAO;
import com.study.myapp.dto.BookDTO;

@Service("service") // 객체생성
public class BookServiceImpl implements BookService {
	
	@Autowired // 주입
	private BookDAO dao;
	
	@Override
	public List<BookDTO> getList() {
		return dao.select();
	}
	
	@Override
	public boolean bookInsert(BookDTO dto) {
		return dao.insert(dto) > 0 ? true : false;
	}
	
}
