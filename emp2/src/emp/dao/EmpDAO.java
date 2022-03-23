package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static emp.dao.JdbcUtil.*;
import emp.dto.EmpDTO;

// CRUD 메소드
public class EmpDAO {
	private Connection con;
	
	public EmpDAO(Connection con) {
		this.con = con;
	}
	
/*────SELECT ALL──────────────────────────────────────────────────────────────────────*/
	public List<EmpDTO> getList() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM exam_emp";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				
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
	
/*────SELECT ONE──────────────────────────────────────────────────────────────────────*/
	public EmpDTO getRow(int empno) {
		EmpDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT empno, ename, job, hiredate, deptno FROM exam_emp WHERE empno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return dto;
	}
	
/*────UPDATE MGR──────────────────────────────────────────────────────────────────────*/
	public boolean updateMgr(int empno, int mgr) {
		PreparedStatement pstmt = null;

		String sql = "UPDATE exam_emp SET mgr = ? WHERE empno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mgr);
			pstmt.setInt(2, empno);
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
	
/*────DELETE EMP──────────────────────────────────────────────────────────────────────*/
	public boolean deleteEmp(int empno) {
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM exam_emp WHERE empno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
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
	
/*────INSERT EMP──────────────────────────────────────────────────────────────────────*/
	public boolean insertEmp(EmpDTO dto) {
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO exam_emp VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getJob());
			pstmt.setInt(4, dto.getMgr());
			pstmt.setInt(5, dto.getSal());
			pstmt.setInt(6, dto.getComm());
			pstmt.setInt(7, dto.getDeptno());
			
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
