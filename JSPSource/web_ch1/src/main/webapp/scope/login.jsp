<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	// setAttribute("key", value);

	// request scope 를 가진 특정 값을 저장d
	request.setAttribute("age", 20);
%>

	<form action="login_request.jsp" method="post">
		<div>
			<label>아이디</label>
			<input type="text" name="userid" id="userid" />
		</div>
		<div>
			<label>비밀번호</label>
			<input type="password" name="password" id="password" />
		</div>
		<div>
			<input type="submit" value="로그인" />
		</div>
	</form>
</body>
</html>