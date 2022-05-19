package com.study.book.service;

import java.util.List;

import com.study.book.dto.BookDTO;

public interface BookService {
	
	public List<BookDTO> getList();
	public List<BookDTO> searchList(String criteria, String keyword);
	public BookDTO select(int code);
	public boolean insert(BookDTO insertDto);
	public boolean update(int code, int price);
	public boolean delete(int code);
	
}
