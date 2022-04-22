package board.service;

import static board.dao.JdbcUtil.*;

import java.sql.Connection;

import board.dao.BoardDAO;

public class BoardDeleteService {
	public boolean deleteBoard(int bno, String password) {
		boolean flag = false;
		
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		if(dao.deleteBoard(bno, password)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		close(con);
		return flag;
	}
}
