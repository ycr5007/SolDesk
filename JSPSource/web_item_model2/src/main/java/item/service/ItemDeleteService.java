package item.service;

import static item.dao.JdbcUtil.*;

import java.sql.Connection;

import item.dao.ItemDAO;

public class ItemDeleteService {
	public boolean deleteItem(int num) {
		boolean flag = false;
		
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		
		if(dao.deleteItem(num)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return flag;
	}
}
