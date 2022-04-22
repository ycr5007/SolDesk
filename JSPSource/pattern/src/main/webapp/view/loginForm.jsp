<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/login.do" method="post">
		<div>
			<label for="userid">ID</label>
			<input type="text" name="userid" id="userid" />
		</div>
		<div>
			<label for="password">PASSWORD</label>
			<input type="password" name="password" id="password" />
		</div>
		<div>
			<button type="submit">Send</button>
		</div>
	</form>
</body>
</html>