<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 장바구니에 담기 ( 세션 ) 
	// session.setAttribute("product", request.getParameter("product"));

	// 기존 세션이 있는지 여부 확인 후 추가
	ArrayList<String> productList = (ArrayList<String>)session.getAttribute("productList");
	
	if(productList == null){
		productList = new ArrayList<String>();
		productList.add(request.getParameter("product"));
	}else{
		productList.add(request.getParameter("product"));
	}
	session.setAttribute("productList", productList);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>제품 추가</h3>
	<p>
		<a href="cart_basket.jsp">장바구니 보기</a>
	</p>
</body>
</html>