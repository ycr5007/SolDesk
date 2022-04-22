package book.service;

import static book.dao.JdbcUtil.*;

import java.sql.Connection;

import book.dao.BookDAO;

public class BookUpdateService {
	public boolean updateBook(int code, int price) {
		boolean flag = false;
		
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		if(dao.modifyPrice(code, price)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		close(con);
		return flag;
	}
}
