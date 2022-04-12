<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	Cookie c = new Cookie("name", "Hong");
	c.setMaxAge(600); // 초 단위
	response.addCookie(c);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="get_cookie2.jsp">쿠키 값 확인</a>
</body>
</html>