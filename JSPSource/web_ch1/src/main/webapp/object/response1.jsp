<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 내장객체
		1) request (HttpServletRequest) : 사용자의 요청을 가져올 수 있다. 
			( 서버가 요구한 자료를 클라이언트가 서버에게 전송하며 요청 )	- 요청한 클라이언트의 정보를 모두 담고 있음 ( 전송한 값, IP ... )
		2) response (HttpServletResponse) : 사용자에게 응답할 때 사용
					.sendRedirect("이동할 Page") : 해당 페이지로 이동 ( Network 상 기록이 남는다 )
			
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// response.sendRedirect("num.jsp");
		response.sendRedirect("http://www.naver.com");
	%>
</body>
</html>