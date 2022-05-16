package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dto.BookDTO;
import com.study.mapper.BookMapper;

@Service("service")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper mapper;
	
	@Override
	public List<BookDTO> getList() {
		return mapper.getList();
	}
	
	@Override
	public BookDTO select(int code) {
		return mapper.select(code);
	}
	
	@Override
	public List<BookDTO> searchList(String criteria, String keyword) {
		return mapper.searchList(criteria, keyword);
	}
	
	@Override
	public boolean insert(BookDTO insertDto) {
		return mapper.insert(insertDto) > 0 ? true : false;
	}
	
	@Override
	public boolean update(int code, int price) {
		return mapper.update(code, price) > 0 ? true : false;
	}
	
	@Override
	public boolean delete(int code) {
		return mapper.delete(code) > 0 ? true : false;
	}
}
