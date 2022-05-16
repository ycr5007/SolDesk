package com.study.myapp.dao;

import static com.study.myapp.dao.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.myapp.dto.BookDTO;

@Repository // 객체생성
public class BookDAO {
	
//	private Connection con;
	
	// HikariCP 적용 ( Config.xml 에서 설정한 HikariDataSource )
	@Autowired
	private DataSource ds; // javax.sql.DataSource
	
	public List<BookDTO> select(){
		List<BookDTO> list = new ArrayList<BookDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from booktbl";
		try {
			// DataSource ( DBCP ) 가 갖고 있는 Connection 을 호출
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				
				dto.setCode(rs.getInt("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		
		return list;
	}
	
	public int insert(BookDTO dto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into booktbl values(?, ?, ?, ?)";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCode());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getWriter());
			pstmt.setInt(4, dto.getPrice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
}
