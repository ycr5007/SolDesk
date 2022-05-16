package com.study.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myapp.dto.BoardDTO;
import com.study.myapp.mapper.BoardMapper;

@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public boolean boardDelete(int bno) {
		return (mapper.delete(bno) > 0 ? true : false);
	}
	@Override
	public boolean boardInsert(BoardDTO insertDTO) {
		return (mapper.insert(insertDTO) > 0 ? true : false);
	}
	@Override
	public boolean boardUpdate(BoardDTO updateDTO) {
		return (mapper.update(updateDTO) > 0 ? true : false);
	}
	@Override
	public List<BoardDTO> boardSelect() {
		return mapper.select();
	}
	@Override
	public BoardDTO getRow(int bno) {
		return mapper.getRow(bno);
	}
}
