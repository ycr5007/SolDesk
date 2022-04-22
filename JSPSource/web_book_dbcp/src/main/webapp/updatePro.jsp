<%@page import="book.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int code = Integer.parseInt(request.getParameter("code"));
	int price = Integer.parseInt(request.getParameter("price"));
	
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	String path = "";
	if(dao.modifyPrice(code, price)){
		JdbcUtil.commit(con);
		System.out.println("수정 성공");
		path = "listPro.jsp";
	}else{
		JdbcUtil.rollback(con);
		System.out.println("수정 실패");
		path = "update.jsp";
	}
	
	JdbcUtil.close(con);
	response.sendRedirect(path);
%>