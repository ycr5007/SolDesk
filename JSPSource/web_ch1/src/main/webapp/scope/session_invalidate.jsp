<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		// 세션을 완전 삭제 ( 세션 ID 초기화 )
		session.invalidate();
		response.sendRedirect("sessionTest1.jsp");
	%>
