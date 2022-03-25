package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;

public class MemberModifyService {
	public boolean memberModify(int id, int menu, String input) {
		boolean isSuccess = false;
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		if(dao.modify(id, menu, input)) {
			commit(con);
			isSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isSuccess;
	}
}
