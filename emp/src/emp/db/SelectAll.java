package emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectAll {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			
			con = DriverManager.getConnection(url, user, password);
			if(con != null) {
				System.out.println("Connect !");
				
				String sql = "SELECT * FROM exam_emp";
				pstmt= con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getInt(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getInt(6) + "\t\t" + rs.getInt(7) + "\t\t" + rs.getInt(8));
				}
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
	}
}
