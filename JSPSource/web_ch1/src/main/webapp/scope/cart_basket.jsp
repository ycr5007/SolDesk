<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 세션 가져오기
	
	ArrayList<String> productList = (ArrayList<String>)session.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>장바구니 보기</h3>
	<ol>
		<%
			for(String product : productList){
				out.print("<li>" + product + "</li>");
			}
		%>
	</ol>
	<p><a href="cart.jsp">상품선택 페이지</a></p>
	<p><a href="cart_remove.jsp">장바구니 비우기</a></p>
</body>
</html>