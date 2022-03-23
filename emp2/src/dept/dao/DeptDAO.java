package dept.dao;

import static dept.dao.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dept.dto.DeptDTO;

public class DeptDAO {
	private Connection con;
	
	
	public DeptDAO(Connection con) {
		this.con = con;
	}
	
	// Select * from exam_dept
	public List<DeptDTO> deptGetList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<DeptDTO> list = new ArrayList<DeptDTO>();
		String sql = "SELECT * FROM exam_dept";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DeptDTO dto = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
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
	
	// Select * from exam_dept Where deptno = ?
	public DeptDTO deptGetRow(int deptno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DeptDTO dto = null;
		String sql = "SELECT * FROM exam_dept WHERE deptno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return null;
	}
	
	// Insert into exam_dept Values(?, ?, ?)
	public boolean deptInsert(DeptDTO dto) {
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO exam_dept(deptno, dname, loc) VALUES(?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
			
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
	
	// Delete From exam_dept Where deptno = ?
	public boolean deptDelete(int deptno) {
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM exam_dept WHERE deptno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
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
	
	// Update exam_dept Set loc = ? Where deptno = ?
	public boolean deptModify(int deptno, String loc) {
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE exam_dept SET loc = ? WHERE deptno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loc);
			pstmt.setInt(2, deptno);
			
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
