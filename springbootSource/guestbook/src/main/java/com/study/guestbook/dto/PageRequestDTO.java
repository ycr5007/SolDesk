package com.study.guestbook.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class PageRequestDTO {
	
// 화면에서 전달되는 목록 데이터
	private int page;	// 현재 페이지 번호
	private int size;	// 페이지 내 보여줄 목록 수
	
	// 검색정보
	private String type;
	private String keyword;
	
	public PageRequestDTO() {
		this.page = 1;
		this.size = 10;
	}
	
	public Pageable getPageable(Sort sort) {
		return PageRequest.of(page - 1, size, sort);
	}
}
