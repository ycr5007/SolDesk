package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.BookDTO;

public interface BookMapper {
	
	public List<BookDTO> getList();
	public List<BookDTO> searchList(@Param("criteria") String criteria, @Param("keyword") String keyword);
	public BookDTO select(int code);
	public int insert(BookDTO insertDto);
	public int delete(int code);
	public int update(@Param("code") int code, @Param("price") int price);
	
}
