package board.dao;

import static board.dao.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;
import board.dto.SearchDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardDAO {
	private Connection con;
	
// CRUD	
	
	// 게시글 삽입
	public boolean insertArticle(BoardDTO dto) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) VALUES(board_seq.nextval, ?, ?, ?, ?, ?, board_seq.currval, ?, ?)";
		/*
			sequence
				nextval : Next Value ( 다음 번호 )
				currval : Current Value ( 최근 발행된 번호 )
		*/
		try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, dto.getName());
	         pstmt.setString(2, dto.getPassword());
	         pstmt.setString(3, dto.getTitle());
	         pstmt.setString(4, dto.getContent());
	         pstmt.setString(5, dto.getAttach());
	         pstmt.setInt(6, 0);
	         pstmt.setInt(7, 0);
	         
	         int result = pstmt.executeUpdate();
	         
	         if(result > 0) {
	            flag = true;
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      return flag;

	}
	
	public List<BoardDTO> getList(SearchDTO searchDto){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
//		String sql = "select bno, title, name, regdate, readcount, re_ref, re_seq, re_lev from board order by re_ref desc, re_seq asc";
		
		try {
			if(searchDto.getCriteria().isEmpty()) {
				sql = "select * from "
						+ "	(select rownum as rnum, A.* from "
						+ "	(select bno, title, name, regdate, readcount, re_ref, re_seq, re_lev from board where bno > 0 order by re_ref desc, re_seq asc) A where rownum <= ?) "
						+ "	where rnum > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, searchDto.getPage() * searchDto.getAmount());
				pstmt.setInt(2, (searchDto.getPage() - 1) * searchDto.getAmount()) ;
			}else {
				sql = "select * from "
						+ "	(select rownum as rnum, A.* from "
						+ "	(select bno, title, name, regdate, readcount, re_ref, re_seq, re_lev from board where bno > 0 and " + searchDto.getCriteria() + " like '%' || ? || '%' order by re_ref desc, re_seq asc) A where rownum <= ?) "
						+ "	where rnum > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, searchDto.getKeyword());
				pstmt.setInt(2, searchDto.getPage() * searchDto.getAmount());
				pstmt.setInt(3, (searchDto.getPage() - 1) * searchDto.getAmount()) ;
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setRownum(rs.getInt("rnum"));
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setRe_ref(rs.getInt("re_ref"));
				dto.setRe_lev(rs.getInt("re_lev"));
				dto.setRe_seq(rs.getInt("re_seq"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setRe_ref(rs.getInt("re_ref")); // 사용 X
				dto.setRe_seq(rs.getInt("re_seq")); // 사용 X
				dto.setRe_lev(rs.getInt("re_lev")); // 사용 O
				
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
	
	// 전체 게시물 개수
	public int getBoardCount(String criteria, String keyword) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(criteria.isEmpty()) {
				sql = "select count(*) from board";
				pstmt = con.prepareStatement(sql);
			}else {
				sql = "select count(*) from board where " + criteria + " like '%' || ? || '%'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, keyword);
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}
	
	public BoardDTO getDetail(int bno) {
		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select bno, name, title, content, attach, re_ref, re_seq, re_lev from board where bno = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				// 댓글 작업에 사용하는 속성
				dto.setRe_ref(rs.getInt("re_ref"));
				dto.setRe_seq(rs.getInt("re_seq"));
				dto.setRe_lev(rs.getInt("re_lev"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return dto;
	}
	
	public boolean hit(int bno) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "update board set readcount = readcount + 1 where bno = ?"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
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
	
	public boolean deleteBoard(int bno, String password) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "delete from board where bno = ? and password = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			
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
	
	public boolean upadateBoard(BoardDTO dto) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "update board set title = ?, content = ?, attach = ? where bno = ? and password = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getAttach());
			pstmt.setInt(4, dto.getBno());
			pstmt.setString(5, dto.getPassword());
			
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
	
	public boolean replyBoard(BoardDTO dto) {
		boolean insFlag = false;
		boolean updFlag = false;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			// 댓글 작업 전 Update 문 실행
			int ref = dto.getRe_ref();
			int seq = dto.getRe_seq();
			int lev = dto.getRe_lev();
			sql = "update board set re_seq = re_seq + 1 where re_ref = ? and re_seq > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, seq);
			
			int updInt = pstmt.executeUpdate();
			if(updInt > 0  || seq == 0) {
				updFlag = true;
			}
			close(pstmt);
			
			// 댓글 Insert 문 실행 
			sql = "insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) "
					+ "values(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getAttach());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, (lev + 1));
			pstmt.setInt(8, (seq + 1));
			
			if(pstmt.executeUpdate() > 0 && updFlag) {
				insFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insFlag;
	}
	
	public List<BoardDTO> searchBoard(SearchDTO searchDto){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select bno, title, name, regdate, readcount, re_ref, re_seq, re_lev from board where " + searchDto.getCriteria() + " like '%' || ? || '%' order by re_ref desc, re_seq asc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchDto.getKeyword());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setRe_ref(rs.getInt("re_ref"));
				dto.setRe_lev(rs.getInt("re_lev"));
				dto.setRe_seq(rs.getInt("re_seq"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setRe_ref(rs.getInt("re_ref")); 
				dto.setRe_seq(rs.getInt("re_seq")); 
				dto.setRe_lev(rs.getInt("re_lev")); 
				
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
