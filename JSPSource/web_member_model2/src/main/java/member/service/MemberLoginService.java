package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberLoginService {
	public MemberDTO loginMember(String userid, String current_password) {
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		MemberDTO dto = dao.isLogin(userid, current_password);
		
		close(con);
		
		return dto;
	}
}
