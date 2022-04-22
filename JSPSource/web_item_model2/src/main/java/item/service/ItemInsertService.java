package item.service;

import static item.dao.JdbcUtil.*;

import java.sql.Connection;

import item.dao.ItemDAO;
import item.dto.ItemDTO;

public class ItemInsertService {
	public boolean insertItem(ItemDTO dto) {
		boolean flag = false;
		
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		
		if(dao.insertItem(dto)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		close(con);
		return flag;
	}
}
