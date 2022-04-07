<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    
    <%--
    	include 페이지 지시자
    		여러개의 Page 를 하나로 만든 후 Compile 진행 ( header.jsp / footer.jsp Compile X ) > .java 파일로 변환되는것은 ( main.jsp )
    		
    		사용 목적 : 페이지의 템플릿화
    --%>
    
    <%
    	int num = 10;
    %>
<%@ include file="./header.jsp"%>
<div>
	<h1>Here Is Main</h1>
	<h2><%=age %></h2>
	<h2><%=num %></h2>
</div>
<%@ include file="./footer.jsp"%>
