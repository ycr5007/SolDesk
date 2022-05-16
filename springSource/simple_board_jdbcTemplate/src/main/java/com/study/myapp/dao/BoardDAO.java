package com.study.myapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.myapp.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<BoardDTO> getList(){
		String sql = "select * from spring_board";
			
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}

	public BoardDTO getRow(int bno) {
		String sql = "select * from spring_board where bno = ?";
		
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper(), bno);
	}
	
	public int insert(BoardDTO dto) {
		String sql = "insert into spring_board(bno, title, content, writer) values (seq_board.nextval, ?, ?, ?)";
		
		int result = jdbcTemplate.update(sql, dto.getTitle(), dto.getContent(), dto.getWriter());
		return result;
	}
	
	public int update(BoardDTO dto) {
		String sql = "update spring_board set title = ?, content = ?, updatedate = (select sysdate from dual) where bno = ?";

		int result =  jdbcTemplate.update(sql, dto.getTitle(), dto.getContent(), dto.getBno());
		return result;
	}
	
	public int delete(int bno) {
		String sql = "delete from spring_board where bno = ?";

		int result = jdbcTemplate.update(sql, bno);
		return result;
	}
}
