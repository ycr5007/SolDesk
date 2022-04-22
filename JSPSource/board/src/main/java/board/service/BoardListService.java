package board.service;

import static board.dao.JdbcUtil.close;
import static board.dao.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.SearchDTO;

public class BoardListService {
	public List<BoardDTO> getList(SearchDTO dto){
		
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		List<BoardDTO> list = dao.getList(dto);
		
		close(con);
		
		return list;
	}
}
