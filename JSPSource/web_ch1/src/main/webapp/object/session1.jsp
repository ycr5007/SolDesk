<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 내장객체
		1) request (HttpServletRequest) : 사용자의 요청을 가져올 수 있다. 
			( 서버가 요구한 자료를 클라이언트가 서버에게 전송하며 요청 )	- 요청한 클라이언트의 정보를 모두 담고 있음 ( 전송한 값, IP ... )
		2) response (HttpServletResponse) : 사용자에게 응답할 때 사용
		3) pageContext (PageContext) : 다른 내장 객체에 접근 가능한 객체
		4) session (HttpSession) : http 프로토콜이 갖고 있는 단점 보완 ( stateless : 상태유지 X ) ex) 로그인, 사용자 활동기록 ...
						.setMaxInactiveInterval(second) : session 의 유효시간을 second 만큼 지정한다.
						.isNew() 						: 새롭게 접속된 세션인지 여부 확인 (true, false)
						.getCreationTime() 				: 세션이 생성된 시간 (ms 단위)
						.getLastAccessedTime() 			: 세션에 접속한 마지막 시간 (ms 단위)
						.getId() 						: 생성된 세션 ID ( 개발자도구 > Application > 쿠키탭에서 확인 가능
		5) application (ServletContext) : 서버측 정보와 서버측 자원에 대한 정보 및 해당 Application의 이벤트 로그를 다루는 객체
		6) out (JspWriter)
			
--%>    

<%--
	Session : 세션이 시작되는 시점 ( 처음 request 한 시점 )
			: 세션이 종료되는 시점 ( 브라우저를 닫는 시점 )
			┌──────→ 세션 시작 →─────┐
		Client 					Server
			└──────← 세션 종료 ←─────┘
 --%>
 
 <%
 	session.setMaxInactiveInterval(10);						// 세션의 유효시간 설정 (s 단위)
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Session Test</h3>
	<p>isNew() : <%=session.isNew() %></p>					<!-- 새롭게 접속된 세션인지 여부 -->
	<p>생성시간 : <%=session.getCreationTime() %></p>			<!-- 세션이 생성된 시간 (ms 단위) -->
	<p>최종접속시간 : <%=session.getLastAccessedTime() %></p>	<!-- 세션에 접속한 마지막 시간 (ms 단위) -->
	<p>세션ID : <%=session.getId() %></p>						<!-- 생성된 세션 ID -->
</body>
</html>