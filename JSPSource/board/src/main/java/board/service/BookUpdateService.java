package board.service;

import static board.dao.JdbcUtil.*;

import java.sql.Connection;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BookUpdateService {
	public boolean updateBoard(BoardDTO dto) {
		boolean flag = false;
		
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		if(dao.upadateBoard(dto)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		close(con);
		return flag;
	}
}
