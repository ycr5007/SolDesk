package com.study.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.board.dto.Criteria;
import com.study.board.dto.ReplyDTO;

@Mapper
public interface ReplyMapper {
	public int insert(ReplyDTO insertDto);
	public ReplyDTO read(int rno);
	public int update(ReplyDTO updateDto);
	public int delete(int rno);
	public List<ReplyDTO> list(@Param("cri") Criteria cri, @Param("bno") int bno);
	public int getCountBno(int bno);
	
	// 게시글 삭제 시 모든 댓글 삭제 (Cascade)
	public int deleteAll(int bno);
}
