<%@page import="member.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	각 객체들의 유효 범위 ( Scope )
		JSP 에서 제공하는 내장 객체들 중 page, request, session, application 
		객체들은 해당 객체에 유효한 범위 안에서 필요한 객체(데이터)들을 저장하고 읽어 들임으로써 서로 공유할 수 있는 특정한 영역을 가지고 있다.
			>> setAttribute() => getAttribute()
			>> form / a 태그를 통해 넘어 온 값 불러오기 => getParameter()		
			1) (X)page : 현재 서비스되고 있는 페이지
				
			2) request : request ( form 태그, a 태그 (QeuryString) )
					§ 모든 페이지는 각각 다른 request, response 객체를 갖는다 ( 단, forward 된 페이지는 예외 )
			3) session
					§ 유지시간(setMaxInactiveInterval)만큼 유효
						> 세션 종료 :
					§ 브라우저를 닫는 순간까지 유효
					§ Session 에 담긴 값은 Server에 저장된다.
			4) (X)application : 서버의 시작과 끝의 유효범위를 가진다 ( AWS ) 
 --%>
 
 <%
	request.setCharacterEncoding("utf-8");
	LoginDTO loginDto = (LoginDTO)session.getAttribute("loginDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>현재 Session 에 담긴 값</h2>
	<p>user ID : <%=loginDto.getUserid() %></p>
	<p>password : <%=loginDto.getPassword() %></p>
</body>
</html>