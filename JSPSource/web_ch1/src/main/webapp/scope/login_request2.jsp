<%@page import="member.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// session 에 입력되는 모든 값은 Object Type 으로 저장된다. 따라서, 자료형에 맞게 형변환이 필요하다.
	LoginDTO loginDto = (LoginDTO)session.getAttribute("loginDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- login.jsp 에서 사용자가 입력값 출력이 가능한지? --%>
	<h2>form 태그에서 넘어온 값</h2>
	<p>user ID : <%=request.getParameter("userid") %></p>
	<p>password : <%=request.getParameter("password") %></p>
	
	<h2>현재 Session 에 담긴 값</h2>
	<p>user ID : <%=loginDto.getUserid() %></p>
	<p>password : <%=loginDto.getPassword() %></p>
	<br />
	<a href="scope1.jsp">이동하기</a>
</body>
</html>