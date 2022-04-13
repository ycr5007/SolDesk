<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./bootstrap-4.6.1-dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="./css/mystyle.css" />
<style>
tbody > tr:hover{
	background-color: #ccc;
	transition: 0.5s;
}
.topnav a:hover{
	color: #f33;
	transform: scale(1.1);
	transition: 0.5s;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="topnav">
			<a href="/insert.jsp">MEMBER 입력</a>
			<a href="/list.jsp">MEMBER 전체조회</a>
		</div>
	<div>