package com.study.guestbook.service;

import com.study.guestbook.dto.GuestbookDTO;
import com.study.guestbook.dto.PageRequestDTO;
import com.study.guestbook.dto.PageResultDTO;
import com.study.guestbook.entity.Guestbook;

public interface GuestbookService {
	// 등록
	Long register(GuestbookDTO insertDto);
	
	// 목록
	PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDto);
	
	// 조회
	GuestbookDTO getOne(Long gno);
	
	// 수정
	Long modify(GuestbookDTO updateDto);
	
	// 삭제
	void remove(Long gno);
	
	default Guestbook dtoToEntity(GuestbookDTO dto) {
		Guestbook entity = Guestbook.builder()
									.title(dto.getTitle())
									.content(dto.getContent())
									.writer(dto.getWriter())
									.build();
		return entity;
	}

	default GuestbookDTO entityToDto(Guestbook entity) {
		GuestbookDTO dto = GuestbookDTO.builder()
									.gno(entity.getGno())
									.title(entity.getTitle())
									.content(entity.getContent())
									.writer(entity.getWriter())
									.regdate(entity.getRegdate())
									.updatedate(entity.getUpdatedate())
									.build();
		return dto;
	}
	
}
