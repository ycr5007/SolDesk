<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/name2" method="post">
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
