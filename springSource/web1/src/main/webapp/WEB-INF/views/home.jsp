<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>

<%-- 	
		/ 로 시작하는 경로 : 절대경로
			url 주소에 맞춤
		
		이름으로 시작하는 경로 / . 으로 시작하는 경로 : 상대경로
			파일 위치에 맞춤
--%>

	<p>
		<%-- 모든 요청은 Controller 로 가야한다. --%>
		<a href="/sample/basic">basic Page</a>
		<a href="./sample/doA">doA</a>
		<a href="/sample/login">login Page</a>
		<a href="/sample/insert">insert Page</a>
	</p>
	
<h3>num[addFlashAttribute] : ${num }</h3>
<h3>age[addAttribute] : <%=request.getParameter("age") %></h3>
<h3>ID : ${user.userid }</h3>
<h3>Password : ${user.password }</h3>
</div>
</body>
</html>
