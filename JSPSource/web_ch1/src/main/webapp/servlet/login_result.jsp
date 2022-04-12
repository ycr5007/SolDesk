<%@page import="member.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LoginDTO dto = (LoginDTO)session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=dto.getUserid() %></h3>
	<h3><%=dto.getPassword() %></h3>
</body>
</html>