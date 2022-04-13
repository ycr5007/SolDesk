<%@page import="java.sql.Connection"%>
<%@page import="book.dao.JdbcUtil"%>
<%@page import="book.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int code = Integer.parseInt(request.getParameter("code"));

	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	String path = "";
	if(dao.deleteBook(code)){
		JdbcUtil.commit(con);
		System.out.println("삭제 성공");
		path = "listPro.jsp";
	}else{
		JdbcUtil.rollback(con);
		System.out.println("삭제 실패");
		path = "delete.jsp";
	}
	
	JdbcUtil.close(con);
	response.sendRedirect(path);
%>
