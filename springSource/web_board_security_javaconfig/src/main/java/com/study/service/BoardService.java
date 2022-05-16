package com.study.service;

import java.util.List;

import com.study.dto.AttachDTO;
import com.study.dto.BoardDTO;
import com.study.dto.Criteria;

public interface BoardService {
	public List<BoardDTO> getList(Criteria cri);
	public void register(BoardDTO register);
	public BoardDTO getOne(int bno);
	public boolean modify(BoardDTO modify);
	public boolean remove(int bno);
	public int getTotalCnt(Criteria cri);
	
	
	// 첨부파일 
	public List<AttachDTO> attachList(int bno);
}
