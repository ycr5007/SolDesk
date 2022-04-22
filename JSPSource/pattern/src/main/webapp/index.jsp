<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/insert.do" method="post">
		<div>
			<label for="userid">USERID</label>
			<input type="text" name="userid" id="userid" />
		</div>
		<div>
			<button type="submit">Send</button>
		</div>
	</form>
	
	<a href="/select.do">do</a>
</body>
</html>