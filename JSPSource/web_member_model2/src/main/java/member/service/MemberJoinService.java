package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberJoinService {
	public boolean joinMember(MemberDTO dto) {
		boolean flag = false;
		
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		if(dao.register(dto)){
			commit(con);
			flag = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return flag;
	}
}
