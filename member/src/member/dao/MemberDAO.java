package member.dao;

import static member.dao.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import member.dto.MemberDTO;

// CRUD
public class MemberDAO {

	Connection con;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	// C(insert) 담당
	public boolean insert(MemberDTO insertDto) {
		String sql = "INSERT INTO member VALUES(member_seq.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getName());
			pstmt.setString(2, insertDto.getAddr());
			pstmt.setString(3, insertDto.getEmail());
			pstmt.setInt(4, insertDto.getAge());
			
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
	
	// R(select) 담당
	public List<MemberDTO> getList() {
		String sql = "SELECT * FROM member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				dto.setAge(rs.getInt("age"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	// U(Update) 담당 ( 1 - 주소, 2 - 이메일 )
		// ? : 필드명(Column) 은 매개변수를 활용해 받을 수 없다, 값만 대입 가능 (필드명을 DB 에서 들어오는 값을 예상하는 도구이기 때문에 임의의 상태로 둘 수 없음) 
	public boolean modify(int id, int menu, String input) {
		String sql = "";
		if(menu == 1) {
			sql = "UPDATE member SET addr = ? WHERE id = ?";
		}else {
			sql = "UPDATE member SET email = ? WHERE id = ?";
		}
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, input);
			pstmt.setInt(2, id);
			
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
	
	// D(Delete) 담당
	public boolean remove(int id) {
		String sql = "DELETE FROM member WHERE id = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
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
