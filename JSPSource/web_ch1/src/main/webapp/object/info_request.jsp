<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// info.jsp 에서 사용자가 넘긴 값 가져오기 (form 안에서 불러오는 값은 String 형태로 값을 가져온다)
		request.setCharacterEncoding("utf-8");
	
		String userid = request.getParameter("userid"); 	// text
		String password = request.getParameter("password"); // password
		String job = request.getParameter("job"); 			// select
		String[] favorite = request.getParameterValues("favorite"); // checkbox (다중선택의 경우, getParameterValues() : 배열의 형태로 가져옴)
		String gender = request.getParameter("gender"); 	// radio
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>userid : <%=userid %></p>
	<p>password : <%=password %></p>
	<p>job : <%=job %></p>
	<p>favorite : <%=Arrays.toString(favorite) %></p>
	<p>gender : <%=gender %></p>
</body>
</html>