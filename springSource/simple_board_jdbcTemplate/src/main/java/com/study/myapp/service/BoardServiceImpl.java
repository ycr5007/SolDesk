package com.study.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myapp.dao.BoardDAO;
import com.study.myapp.dto.BoardDTO;

@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public boolean boardDelete(int bno) {
		return (dao.delete(bno) > 0 ? true : false);
	}
	@Override
	public boolean boardInsert(BoardDTO insertDTO) {
		return (dao.insert(insertDTO) > 0 ? true : false);
	}
	@Override
	public boolean boardUpdate(BoardDTO updateDTO) {
		return (dao.update(updateDTO) > 0 ? true : false);
	}
	@Override
	public List<BoardDTO> getList() {
		return dao.getList();
	}
	@Override
	public BoardDTO getRow(int bno) {
		return dao.getRow(bno);
	}
}
