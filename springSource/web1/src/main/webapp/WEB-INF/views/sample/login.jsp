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
			<label for="userid">ID</label>
			<input type="text" name="userid" id="userid" />
		</div>
		<div>
			<label for="password">Password</label>
			<input type="password" name="password" id="password" />
		</div>
		<!-- <div>
			<label for="addr">Address</label>
			<input type="text" name="addr" id="addr" />
		</div>
		<div>
			<label for="age">Age</label>
			<input type="text" name="age" id="age" />
		</div> -->
		<div>
			<button type="submit">Send</button>
		</div>
	</form>
	
</body>
</html>
