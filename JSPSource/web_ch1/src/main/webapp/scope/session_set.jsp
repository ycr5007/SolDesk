<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		session.setAttribute("name", "session test!!");
		session.setAttribute("age", 25);
		response.sendRedirect("sessionTest1.jsp");
	%>
