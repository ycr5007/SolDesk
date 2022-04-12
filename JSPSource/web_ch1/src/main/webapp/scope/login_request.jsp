<%@page import="member.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	
	// session.setAttribute("userid", userid);
	// session.setAttribute("password", password);
	
	session.setAttribute("loginDto", new LoginDTO(userid, password));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 정보</h3>
	<p>user id : <%=userid %></p> <!-- form / QueryString 안에 있는 데이터를 가져오는 특수 Method -->
	<p>password : <%=password %></p> 
	<p>age : <%=request.getAttribute("age") %></p> <!-- login.jsp (request) ≠ login_request.jsp (request) >> 두 request 가 다르기 떄문에 값을 불러오지 못함 -->
	<p><a href="login_request2.jsp">이동</a></p>
</body>
</html>