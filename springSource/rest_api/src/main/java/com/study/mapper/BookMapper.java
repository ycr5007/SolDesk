package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.dto.BookDTO;

public interface BookMapper {
	public List<BookDTO> select();
	public List<BookDTO> search(@Param("criteria") String criteria, @Param("keyword") String keyword);
	
	public int insert(BookDTO insertDto);
	public int update(@Param("code") int code, @Param("price") int price);
	public int delete(int code);
	public BookDTO get(int code);
	
	
}
