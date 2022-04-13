package member.dao;

import static member.dao.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;

@AllArgsConstructor
public class MemberDAO {
	Connection con = null;
	
	/*
		C : 회원가입
		R : 로그인
		U : 비밀번호 변경
		D : 회원탈퇴
	*/
	
	
	// Login : 사용자가 입력한 아이디, 비밀번호가 존재하는지 여부 확인
	public MemberDTO isLogin(String userid, String password) {
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userid, name from membertbl where userid = ? and password = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return dto;
	}
	
	public boolean modifyPassword(String userid,String password , String changePassword) {
		if(isLogin(userid, password) == null) {
			return false;
		}
		
		PreparedStatement pstmt = null;
		String sql = "update membertbl set password = ? where userid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, changePassword);
			pstmt.setString(2, userid);
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
	
	public boolean deleteMember(String userid, String password) {
		PreparedStatement pstmt = null;
		String sql = "delete from membertbl where userid = ? and password = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
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
	
	public boolean register(MemberDTO dto) {
		PreparedStatement pstmt = null;
		String sql = "insert into membertbl values(?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getEmail());
			
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
