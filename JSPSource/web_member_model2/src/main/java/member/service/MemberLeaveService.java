package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;

public class MemberLeaveService {
	public boolean leaveMember(String userid, String current_password) {
		Boolean flag = false;
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		if(dao.deleteMember(userid, current_password)) {
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		close(con);
		return flag;
	}
}
