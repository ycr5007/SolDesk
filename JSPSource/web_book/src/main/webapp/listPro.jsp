<%@page import="book.dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="book.dao.BookDAO"%>
<%@page import="book.dao.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	BookDAO dao = new BookDAO(JdbcUtil.getConnection());
	List<BookDTO> list = dao.getList();
	
	request.setAttribute("list", list);
	pageContext.forward("list.jsp");	
%>