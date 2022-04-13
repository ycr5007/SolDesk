package web2.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionTest {
	public static void main(String[] args) {
		// JDBC

		Connection con = null;
		try {
			// 1) Driver load
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2) Connection DB
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "javadb";
			String password = "12345";
			con = DriverManager.getConnection(url, user, password);
			
			if(con != null) {
				System.out.println("Connection");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 3) SQL 전송
			
			// 4) SQL 실행
			
			// 5) 실행결과 반환
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
