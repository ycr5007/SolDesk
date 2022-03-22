package emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
	public static void main(String[] args) {
		// DB 연결 객체
		Connection con = null;
		// SQL 쿼리문 전송 객체
		PreparedStatement pstmt = null;
		// 쿼리문 결과를 담는 객체 ( SELECT 쿼리문 )
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			
			con = DriverManager.getConnection(url, user, password);
			
			if(con != null) {
				System.out.println("Connect !");
				
				// SQL 쿼리문
				String sql = "SELECT * FROM emp WHERE empno = 7369";
				pstmt = con.prepareStatement(sql);
				
				// executeUpdate() · executeQuery() > 실제 쿼리문 실행
					// executeUpdate() >> Insert, Update, Delete
					// executeQuery() >> Select
				rs = pstmt.executeQuery();
				
				// rs 에 담긴 결과 출력 ( 테이블의 형태로 담겨져 있음 )
				if(rs.next()) { // Query 결과값이 담겨있는지 확인
					// Column 하나씩 가져오기
					int empno  = rs.getInt("empno"); // Column 명으로 값 가져오기
					String ename = rs.getString(2); // Column 인덱스로 가져오기 ( 1 ~ x )
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					String hiredate = rs.getString("hiredate"); // Date 형으로 가져올 수 있음
					int sal = rs.getInt("sal");
					int comm = rs.getInt(7);
					int deptno = rs.getInt(8);
					
					System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t" + comm + "\t" + deptno);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
