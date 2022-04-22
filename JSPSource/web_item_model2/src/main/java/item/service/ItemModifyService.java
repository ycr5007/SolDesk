package item.service;

import static item.dao.JdbcUtil.*;

import java.sql.Connection;

import item.dao.ItemDAO;

public class ItemModifyService {
	public boolean modifyItem(int num, String psize, int price) {
		boolean flag = false;
		
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		
		if(dao.modifyItem(num, psize, price)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return flag;
	}
}
