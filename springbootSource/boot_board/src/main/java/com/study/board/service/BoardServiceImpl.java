package com.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.board.dto.AttachDTO;
import com.study.board.dto.BoardDTO;
import com.study.board.dto.Criteria;
import com.study.board.mapper.AttachMapper;
import com.study.board.mapper.BoardMapper;
import com.study.board.mapper.ReplyMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private AttachMapper attachMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public List<BoardDTO> getList(Criteria cri) {
		return boardMapper.getList(cri);
	}
	
	@Transactional
	@Override
	public void register(BoardDTO register) {
		// 새글 등록
		boardMapper.register(register);

		
		
		// 첨부파일 삽입
		// 첨부파일이 없다면 return
		if(register.getAttachList() == null || register.getAttachList().size() <= 0) {
			return;
		}
		
		// 첨부 파일 개수만큼 반복 ( forEach : 함수형 )
		register.getAttachList().forEach(attach -> {
			attach.setBno(register.getBno());
			attachMapper.insert(attach);
		});
	}
	
	@Override
	public BoardDTO getOne(int bno) {
		BoardDTO getDto = boardMapper.getOne(bno);
//		getDto.setAttachList(attachMapper.getList(bno));
		return getDto;
	}
	
	@Transactional
	@Override
	public boolean modify(BoardDTO modify) {
		// 첨부파일 수정 ( 기존 첨부파일 삭제 )
		attachMapper.deleteAll(modify.getBno());
		
		// 첨부파일 수정 ( 수정 시 입력한 파일 목록 DB 삽입 )
		if(modify.getAttachList() != null && modify.getAttachList().size() > 0) {
			for(AttachDTO attach : modify.getAttachList()) {
				attach.setBno(modify.getBno());
				attachMapper.insert(attach);
			}
		}
		
		return boardMapper.modify(modify) > 0 ? true : false;
	}
	
	@Transactional
	@Override
	public boolean remove(int bno) {
		// 첨부파일 삭제
		attachMapper.deleteAll(bno);
		// 댓글 삭제
		replyMapper.deleteAll(bno);
		
		return boardMapper.remove(bno) > 0 ? true : false;
	}
	
	@Override
	public int getTotalCnt(Criteria cri) {
		return boardMapper.totalCnt(cri);
	}
	
	@Override
	public List<AttachDTO> attachList(int bno) {
		return attachMapper.getList(bno);
	}
}
