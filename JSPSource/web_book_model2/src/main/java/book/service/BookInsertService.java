package book.service;

import static book.dao.JdbcUtil.*;

import java.sql.Connection;

import book.dao.BookDAO;
import book.dto.BookDTO;

// Model : 

public class BookInsertService {
	public boolean insertBook(BookDTO dto) {
		boolean flag = false;
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		if(dao.insertBook(dto)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return flag;
	}
}
