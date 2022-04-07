<!-- page 지시어 -->
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML 주석 -->
<%-- JSP 주석 --%>
<%
	// JAVA 코드 내 한 줄 주석
	/* JAVA 코드 내 여러 줄 주석 */
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	
	// 브라우저에 자바 값을 출력하는 방법 ①
	out.print("<p>" + sdf.format(date) + "</p>");
%>

	<!-- 브라우저에 자바 값을 출력하는 방법 ②  -->
	<p><%=sdf.format(date) %></p>
	
	<!-- 브라우저에서는 Java 및 페이지 지시 코드를 인식하지 못함 ( 브라우저 상세보기로 확인 X (JSP 주석 포함))  -->
</body>
</html>