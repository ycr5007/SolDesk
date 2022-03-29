package emp.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
	서비스 관리 업무

		C : INSERT
		R : SELECT
		U : UPDATE
		D : DELETE
		
	DAO(Data Access Object) : Database (CRUD) 작업 클래스
	
		Return 의 형태
			DTO 객체 : 한 개의 행을 조회할 때
			List<DTO> : 여러 개의 행을 조회할 떄
			int : INSERT, UPDATE, DELETE 작동 여부 확인 int 값 ( 성공한 행의 개수 ) 
*/

public class EmpDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// Connection 메소드
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			
			con = DriverManager.getConnection(url, user, password);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
/*────SELECT ALL──────────────────────────────────────────────────────────────────────*/
	public List<EmpDTO> getList() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM exam_emp";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// rs 에 담긴 SQL 실행 결과를 List에 담아서 Reutrn
			
			while(rs.next()) {
				// 행의 각 Column 을 가져와서 EmpDTO 객체로 만들어준다.

//				EmpDTO dto = new EmpDTO();
//				dto.setEmpno(rs.getInt("empno"));
//				dto.setEname(rs.getString("ename"));
//				dto.setJob(rs.getString("job"));
//				dto.setMgr(rs.getInt("mgr"));
//				dto.setHiredate(rs.getDate("hiredate"));
//				dto.setSal(rs.getInt("sal"));
//				dto.setComm(rs.getInt("comm"));
//				dto.setDeptno(rs.getInt("deptno"));
				
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
/*────SELECT ONE──────────────────────────────────────────────────────────────────────*/
	public EmpDTO getRow(int empno) {
		EmpDTO dto = null;
		try {
			con = getConnection();
			
			// ? : 변수로 지정한 뒤, 나중에 값을 넣어 조회 ( Statement 와 PreparedStatement 의 차이 )
			String sql = "SELECT empno, ename, job, hiredate, deptno FROM exam_emp WHERE empno = ?";
			pstmt = con.prepareStatement(sql);
			// ? 값 지정 방법 : pstmt.setType(index, value); >> index 는 1부터 시작하며, 앞에서부터 순서대로 적용된다.
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
/*────UPDATE MGR──────────────────────────────────────────────────────────────────────*/
	public int updateMgr(int empno, int mgr) {
		try {
			con = getConnection();
			
			String sql = "UPDATE exam_emp SET mgr = ? WHERE empno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mgr);
			pstmt.setInt(2, empno);
			
			return pstmt.executeUpdate(); // 정상작동
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1; // 실패
	}
	
/*────DELETE EMP──────────────────────────────────────────────────────────────────────*/
	public int deleteEmp(int empno) {
		try {
			con = getConnection();
			
			String sql = "DELETE FROM exam_emp WHERE empno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;
	}
	
/*────INSERT EMP──────────────────────────────────────────────────────────────────────*/
	// value too large for column "SCOTT"."EXAM_EMP"."JOB" (actual: 15, maximum: 9) > Column 데이터 형식( 타입, 사이즈 확인 )
		// 한글의 경우 BYTE 계산 주의 ( 1글자 3Byte )
//	public int insertEmp(int empno, String ename, String job, int mgr, int sal, int comm, int deptno) {
//		try {
//			con = getConnection();
//			
//			// 주의 ! Oracle 데이터 삽입 시, Column 데이터 크기 값 고려해서 데이터 삽입할 것
//			String sql = "INSERT INTO exam_emp VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, empno);
//			pstmt.setString(2, ename);
//			pstmt.setString(3, job);
//			pstmt.setInt(4, mgr);
//			pstmt.setInt(5, sal);
//			pstmt.setInt(6, comm);
//			pstmt.setInt(7, deptno);
//			
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//				con.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return -1;
//	}
	
	public int insertEmp(EmpDTO dto) {
		try {
			con = getConnection();
			
			// 주의 ! Oracle 데이터 삽입 시, Column 데이터 크기 값 고려해서 데이터 삽입할 것
			String sql = "INSERT INTO exam_emp VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getJob());
			pstmt.setInt(4, dto.getMgr());
			pstmt.setInt(5, dto.getSal());
			pstmt.setInt(6, dto.getComm());
			pstmt.setInt(7, dto.getDeptno());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;
	}

}
