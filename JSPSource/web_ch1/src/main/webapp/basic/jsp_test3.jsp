<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 1 ~ 100 까지 합계를 구한 뒤 출력 --%>
	<% 
		int sum = 0;
		for(int i = 1 ; i <= 100; i++ ){
			sum += i;
			out.print("<h3>" + sum + "</h3>");
		}
	%>
	
	<h4><%=sum %></h4>
</body>
</html>