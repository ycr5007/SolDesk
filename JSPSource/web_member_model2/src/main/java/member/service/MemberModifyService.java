package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;

public class MemberModifyService {
	public boolean modifyPassword(String userid, String current_password, String new_password) {
		boolean flag = false;
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		if(dao.modifyPassword(userid, current_password, new_password)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return flag;
	}
}
