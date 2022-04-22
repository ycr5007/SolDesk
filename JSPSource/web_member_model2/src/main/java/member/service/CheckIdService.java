package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;

public class CheckIdService {
	public boolean checkId(String userid) {
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		boolean flag = dao.checkId(userid);
		
		close(con);
		return flag;
	}
}
