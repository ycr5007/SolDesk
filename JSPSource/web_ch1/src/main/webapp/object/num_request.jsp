<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%=request.getParameter("num") %> |||||||| <%=request.getParameter("page") %></h2>
	<p>왜눌렀어요 ㅠ</p>
	
	<h3>클라이언트 IP 주소 : <%=request.getRemoteAddr() %></h3> <!-- local : 0:0:0:0:0:0:0:1 -->
	<h3>프로토콜 : <%=request.getProtocol() %></h3>
	<h3>요청메소드 : <%=request.getMethod() %></h3>
	<h3><a href="response1.jsp">이곳으로 이동</a></h3>
</body>
</html>