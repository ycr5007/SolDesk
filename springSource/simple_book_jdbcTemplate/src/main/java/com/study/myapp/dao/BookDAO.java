package com.study.myapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.myapp.dto.BookDTO;

@Repository // 객체생성
public class BookDAO {
	
//	private Connection con;
	
	// HikariCP 적용 ( Config.xml 에서 설정한 HikariDataSource )
//	@Autowired
//	private DataSource ds; // javax.sql.DataSource

	// Spring JDBC 적용 ( Config.xml 에서 설정한 JdbcTemplate )
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<BookDTO> select(){
		String sql = "select * from booktbl";
		
		// Spring JDBC 활용 ( Select / BookRowMapper )
		return jdbcTemplate.query(sql, new BookRowMapper());
	}
	
	public int insert(BookDTO dto) {
		String sql = "insert into booktbl values(?, ?, ?, ?)";
		
		// Spring JDBC 활용 ( Insert )
		int result = jdbcTemplate.update(sql, dto.getCode(), dto.getTitle(), dto.getWriter(), dto.getPrice());
		return result;
		
	}

	public int update(int code, int price) {
		String sql = "update booktbl set price = ? where code = ?";
		
		// Spring JDBC 활용 ( Update )
		int result = jdbcTemplate.update(sql, price, code);
		return result;
	}
	
	public int delete(int code) {
		String sql = "delete from booktbl where code = ?";
		
		// Spring JDBC 활용 ( Update )
		int result = jdbcTemplate.update(sql, code);
		return result;
	}
}
