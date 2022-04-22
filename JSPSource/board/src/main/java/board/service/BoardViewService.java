package board.service;

import static board.dao.JdbcUtil.*;

import java.sql.Connection;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardViewService {
	public BoardDTO getDatail(int bno) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);

		BoardDTO dto = dao.getDetail(bno);
		
		close(con);
		return dto;
	}
}
