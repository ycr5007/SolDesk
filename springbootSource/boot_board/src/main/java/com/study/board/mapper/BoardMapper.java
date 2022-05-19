package com.study.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.board.dto.BoardDTO;
import com.study.board.dto.Criteria;

@Mapper
public interface BoardMapper {

	// C
	public int register(BoardDTO register);
	
	// R
	public List<BoardDTO> getList(Criteria cri);
	public BoardDTO getOne(int bno);
	
	// U
	public int modify(BoardDTO modify);
	// D
	public int remove(int bno);
	
	public int totalCnt(Criteria cri);
	
	// 트랜잭션 처리 필요 ( reply & board 두 테이블의 작업이 한번에 이루어지기 떄문에, 작업을 묶어줄 필요가 있음 )
	public int updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
}
