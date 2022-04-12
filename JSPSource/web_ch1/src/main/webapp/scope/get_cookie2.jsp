<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 쿠키 값 가져오기
	String cookies = request.getHeader("Cookie");
	String name = "", value = "";
	if(cookies != null){
		Cookie[] cookie = request.getCookies();
		for(Cookie c : cookie){
			if(c.getName().equals("name")){
				name = c.getName();
				value = c.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Cookie : <%=cookies %></h2>
	
	<h5>name : <%=name %></h5>
	<h5>value : <%=value %></h5>
</body>
</html>