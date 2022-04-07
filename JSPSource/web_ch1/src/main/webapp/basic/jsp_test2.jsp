<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    <!-- errorPage="Page" : Error 발생 시 이동할 페이지 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int a = 1, b = 0;
	%>
	<p>a 와 b 의 사칙연산</p>
	<p>a + b = <%=a+b %></p>
	<p>a - b = <%=a-b %></p>
	<p>a * b = <%=a*b %></p>
	<p>a / b = <%=a/b %></p>
	
	<!-- 
		상태코드
                1xx (정보) : 요청을 받았으며 프로세스를 계속 진행
                2xx (성공) : 요청을 성공적으로 받았으며 인식했고 수용
                3xx (리다이렉션) : 요청 완료를 위해 추가 작업 조치가 필요
                4xx (클라이언트 오류) : 요청의 문법이 잘못되었거나 요청을 처리할 수 없음
                5xx (서버 오류) : 서버가 명백히 유효한 요청에 대한 충족을 실패
	 -->
</body>
</html>