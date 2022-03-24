package member.dao;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import member.dto.MemberDTO;

// CRUD
public class MemberDAO {

	Connection con;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	// C(insert) 담당
	public boolean insert(MemberDTO insertDto) {
		String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, insertDto.getId());
			pstmt.setString(2, insertDto.getName());
			pstmt.setString(3, insertDto.getAddr());
			pstmt.setString(4, insertDto.getEmail());
			pstmt.setInt(5, insertDto.getAge());
			
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return false;
	}
	
}
