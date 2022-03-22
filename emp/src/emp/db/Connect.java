package emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
	Library 적용법 
		프로젝트 > Build Path > Configure Build Path > Library (Add JARs...)
	
	JDBC : Java + Database 연결규칙
		> 각 DB 마다 Driver 가 있다.
			> Oracle Driver 	: 	oracle.jdbc.OracleDriver
									oracle.jdbc.driver.OracleDriver (이전 버전)
*/

public class Connect {
	public static void main(String[] args) {
		// ① Database 서버와 연결
		
		try {
			// Driver 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Database 서버와 연결을 위한 문자열 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
						// localhost(127.0.0.1) > DB서버가 설치된 주소값
						// 1521 > 포트번호
						// xe > 설치한 DB 의 이름 ( 버전에 따라 차이가 있음 )
			String user = "scott"; // DB 계정 명
			String password = "TIGER"; // DB 계정 비밀번호
			
			// Driver Manager 를 통해 연결 시도
			Connection con = DriverManager.getConnection(url, user, password);
			
			if(con != null) {
				System.out.println("Connect !");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // Driver 가 현재 프로젝트에 Import 안됨 ( lib Import 要 )
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
