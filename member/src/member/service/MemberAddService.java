package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberAddService {
	public boolean insertMember(MemberDTO insertDto) {
		boolean isAddSuccess = false;
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		if(dao.insert(insertDto)) {
			commit(con);
			isAddSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isAddSuccess;
	}
}
