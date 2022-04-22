package item.dao;

import static item.dao.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import item.dto.ItemDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemDAO {
	private Connection con;
	
	public List<ItemDTO> getList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		String sql = "select num, category, name, psize, price, register_at from item order by num desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setName(rs.getString("name"));
				dto.setPsize(rs.getString("psize"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegister_at(rs.getDate("register_at"));
				
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
	
	public boolean insertItem(ItemDTO dto) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "insert into item(num, category, name, content, psize, price) values(item_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPsize());
			pstmt.setInt(5, dto.getPrice());
			if(pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	public boolean deleteItem(int num) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "delete from item where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			if(pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	public boolean modifyItem(int num, String psize, int price) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "update item set psize = ?, price = ? where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, psize);
			pstmt.setInt(2, price);
			pstmt.setInt(3, num);
			
			if(pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return flag;
	}
	
	public List<ItemDTO> searchItem(String category, String name){
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			if(!category.equals("") && !name.equals("")) {
				sql = "select * from item where category = ? and name = ? order by num desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, category);
				pstmt.setString(2, name);
			}else if(!category.equals("")) {
				sql = "select * from item where category = ? order by num desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, category);
			}else if(!name.equals("")) {
				sql = "select * from item where name = ? order by num desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setName(rs.getString("name"));
				dto.setPsize(rs.getString("psize"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegister_at(rs.getDate("register_at"));
				
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
}
