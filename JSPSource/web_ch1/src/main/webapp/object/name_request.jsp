<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 내장객체
		1) request (HttpServletRequest) : 사용자의 요청을 가져올 수 있다. 
			( 서버가 요구한 자료를 클라이언트가 서버에게 전송하며 요청 )	- 요청한 클라이언트의 정보를 모두 담고 있음 ( 전송한 값, IP ... )
--%>

<%
	/*
		request		.getParameter("form 에서 전달한 name 속성 값") : form 안에 들어있는 정보 / QueryString 안에 들어있는 정보를 가져온다.
						주의 ) get 방식의 경우 Encoding 이 자동으로 적용되지만, post 방식의 경우 인코딩을 따로 지정해주어야 한다.
					.setCharacterEncoding("Encoding Type") : 받아오는 값의 Encoding 지정
	*/
	
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("username");
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=name %></h3>
</body>
</html>