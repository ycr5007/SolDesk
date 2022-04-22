package book.service;

import static book.dao.JdbcUtil.*;

import java.sql.Connection;

import book.dao.BookDAO;

public class BookDeleteService {
	public boolean deleteBook(int code) {
		boolean flag = false;
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		if(dao.deleteBook(code)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		
		return flag;
	}
}
