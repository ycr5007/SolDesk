package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dto.Criteria;
import com.study.dto.ReplyDTO;
import com.study.dto.ReplyPageDTO;
import com.study.mapper.BoardMapper;
import com.study.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public boolean replyInsert(ReplyDTO insertDto) {
		// 원본글의 replyCnt 추가
		boardMapper.updateReplyCnt(insertDto.getBno(), 1);
		return mapper.insert(insertDto) > 0 ? true : false;
	}

	@Override
	public ReplyDTO read(int rno) {
		return mapper.read(rno);
	}
	
	@Override
	public boolean replyUpdate(ReplyDTO updateDto) {
		return mapper.update(updateDto) > 0 ? true : false;
	}
	
	@Override
	public boolean replyDelete(int rno) {
		
		// bno 값 구하기
		ReplyDTO dto = mapper.read(rno);
		
		// 원본글의 replyCnt 감소
		boardMapper.updateReplyCnt(dto.getBno(), -1);
		return mapper.delete(rno) > 0 ? true : false;
	}
	
	@Override
	public ReplyPageDTO getList(Criteria cri, int bno) {
		return new ReplyPageDTO(mapper.getCountBno(bno), mapper.list(cri, bno));
	}
	
//	@Override
//	public int getCountBno(int bno) {
//		return mapper.getCountBno(bno);
//	}
}
