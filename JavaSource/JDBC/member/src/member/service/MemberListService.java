package member.service;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberListService {
	public List<MemberDTO> getMemberList(){
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		List<MemberDTO> list = dao.getList();
		close(con);
		return list;
	}
}
