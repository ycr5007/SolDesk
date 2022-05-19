package com.study.board.service;

import com.study.board.dto.Criteria;
import com.study.board.dto.ReplyDTO;
import com.study.board.dto.ReplyPageDTO;

public interface ReplyService {
	public boolean replyInsert(ReplyDTO insertDto);
	public ReplyDTO read(int rno);
	public boolean replyUpdate(ReplyDTO updateDto);
	public boolean replyDelete(int rno);
	public ReplyPageDTO getList(Criteria cri, int bno);
//	public int getCountBno(int bno);
}
 