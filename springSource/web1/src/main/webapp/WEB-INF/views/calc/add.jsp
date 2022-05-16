<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
<h1>Login</h1>
	<p>
		<a href="/sample/basic">basic Page</a>
		<a href="/sample/doA">doA</a>
		<a href="/">Home</a>
		<a href="/sample/insert">insert Page</a>
	</p>
	<form action="" method="post">
		<div>
			<input type="text" name="num1" id="num1" value="${numDTO.num1 }"/> +
			<input type="text" name="num2" id="num2" value="${numDTO.num2 }" /> =
			
			<%-- <input type="text" name="num1" id="num1" value="${dto.num1 }"/> +
			<input type="text" name="num2" id="num2" value="${dto.num2 }" /> =  --%>
			
			<%-- <input type="text" name="result" id="result" value="${dto.num1 + dto.num2 }" readonly /> --%>
			<input type="text" name="result" id="result" value="${result }" readonly />
			<button type="submit">Send</button>
		</div>
	</form>
	
</body>
</html>
