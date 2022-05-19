package com.study.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.dto.AttachDTO;

@Mapper
public interface AttachMapper {
	// 첨부파일 삽입
	public int insert(AttachDTO attach);
	
	// read.jsp 첨부파일 리스트
	public List<AttachDTO> getList(int bno);
	
	// bno 가 일치하는 첨부파일 모두 삭제
	public int deleteAll(int bno);
	
	// 전날 날짜의 첨부파일 목록
	public List<AttachDTO> getOldFiles();
}
