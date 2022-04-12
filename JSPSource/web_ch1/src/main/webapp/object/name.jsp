<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="name_request.jsp" method="post">
	<!-- 
		form Tag 의 method
			get : 넘겨주는 데이터를 URL 에 남긴채로 보내는 방식 (a 태그로 들어오는 데이터는 get 방식이다.)
			post : 넘겨주는 데이터를 URL 에 남기지 않고, 숨긴 상태로 보내는 방식 (로그인, 회원가입 등 개인정보 보호 목적)
	-->
		<div>
			<label for="username">Name : </label>
			<input type="text" name="username" id="username" required="required"/>
		</div>
		<div>
			<button type="submit">보내기</button>
		</div>
	</form>
</body>
</html>
