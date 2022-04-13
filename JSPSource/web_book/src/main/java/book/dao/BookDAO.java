package book.dao;

import static book.dao.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import book.dto.BookDTO;

public class BookDAO {
	Connection con = null;
	
	public BookDAO(Connection con) {
		this.con = con;
	}
	
	// CRUD
	
	public boolean insertBook(BookDTO dto) {
		PreparedStatement pstmt = null;
		String sql = "insert into BOOKTBL values(?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCode());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getWriter());
			pstmt.setInt(4, dto.getPrice());
			
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
	
	public ArrayList<BookDTO> getList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		String sql = "select * from booktbl order by code asc";
		try {
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
	
	public boolean deleteBook(int code) {
		PreparedStatement pstmt = null;
		String sql = "delete from booktbl where code = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
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
	
	public boolean modifyPrice(int code, int price) {
		PreparedStatement pstmt = null;
		String sql = "update booktbl set price = ? where code = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, code);
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
	
	public ArrayList<BookDTO> searchBook(String writer) {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from booktbl where writer = ? order by code asc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(writer);
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
	
	public ArrayList<BookDTO> searchBook(int code) {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from booktbl where code = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(code);
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
}
