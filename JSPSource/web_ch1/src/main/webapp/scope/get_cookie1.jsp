<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	// 브라우저가 기억하는 쿠키 가져오기 ( 가져온 쿠키들 중, 이름이 일치하는 쿠기의 값 반환하는 메소드 )
	private String getCookieValue(Cookie[] cookies, String name){
		if(cookies == null){
			return null;
		}
		for(Cookie c : cookies){
			if(c.getName().equals(name)){
				return c.getValue();
			}
		}
		return null;
}
%>

<%
	Cookie[] cookies = request.getCookies();
	String name = getCookieValue(cookies, "name");
	String gender = getCookieValue(cookies, "gender");
	String age = getCookieValue(cookies, "age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이름 : <%=name %></h3>
	<h3>성별 : <%=gender %></h3>
	<h3>나이 : <%=age %></h3>
</body>
</html>