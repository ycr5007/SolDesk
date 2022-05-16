package com.study.myapp.service;

import java.util.List;

import com.study.myapp.dto.BookDTO;

public interface BookService {
	public List<BookDTO> getList();
	public List<BookDTO> searchList(String criteria, String keyword);
	public boolean bookInsert(BookDTO dto);
	public boolean bookUpdate(int code, int price);
	public boolean bookDelete(int code);
}
