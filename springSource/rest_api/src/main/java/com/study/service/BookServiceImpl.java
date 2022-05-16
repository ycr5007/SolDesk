package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.BookDTO;
import com.study.mapper.BookMapper;

@Service("service") // 객체생성
public class BookServiceImpl implements BookService {
	
	@Autowired // 주입
	private BookMapper mapper;
	
	@Override
	public List<BookDTO> getList() {
		return mapper.select();
	}
	
	@Override
	public List<BookDTO> searchList(String criteria, String keyword) {
		return mapper.search(criteria, keyword);
	}
	
	@Override
	public boolean bookInsert(BookDTO dto) {
		return mapper.insert(dto) > 0 ? true : false;
	}
	
	@Override
	public boolean bookUpdate(int code, int price) {
		return mapper.update(code, price) > 0 ? true : false;
	}
	
	@Override
	public boolean bookDelete(int code) {
		return mapper.delete(code) > 0 ? true : false;
	}
	
	@Override
	public BookDTO get(int code) {
		return mapper.get(code);
	}
	
}
