package emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			
			con = DriverManager.getConnection(url, user, password);
			
			if(con != null) {
				System.out.println("Connect !");
				
				String sql = "INSERT INTO exam_emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES(7209, 'TEST_USER9', 'MANAGER', 7201, '2016-03-10', 1400, NULL, 80)";
				pstmt = con.prepareStatement(sql);
				
				// 자동으로 Commit 실행 ( 단, 수동 설정 변경 가능 )
				if(pstmt.executeUpdate() > 0) {
					System.out.println("Success !");
				}
			}
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
	}
}
