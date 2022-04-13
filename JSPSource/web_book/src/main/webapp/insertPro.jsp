<%@page import="book.dao.BookDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.dao.JdbcUtil"%>
<%@page import="book.dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	BookDTO dto = new BookDTO();
	dto.setCode(Integer.parseInt(request.getParameter("code")));
	dto.setTitle(request.getParameter("title"));
	dto.setWriter(request.getParameter("writer"));
	dto.setPrice(Integer.parseInt(request.getParameter("price")));
	
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	String path = "";
	if(dao.insertBook(dto)){
		System.out.println("삽입성공");
		JdbcUtil.commit(con);
		path = "listPro.jsp";
	}else{
		System.out.println("삽입실패");
		JdbcUtil.rollback(con);
		path = "insert.jsp";
	}
	JdbcUtil.close(con);
	response.sendRedirect(path);
%>