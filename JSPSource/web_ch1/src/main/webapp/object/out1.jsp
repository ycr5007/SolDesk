<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 내장객체
		1) (★)request (HttpServletRequest) : 사용자의 요청을 가져올 수 있다. 
			( 서버가 요구한 자료를 클라이언트가 서버에게 전송하며 요청 )	- 요청한 클라이언트의 정보를 모두 담고 있음 ( 전송한 값, IP ... )
		2) (★)response (HttpServletResponse) : 사용자에게 응답할 때 사용
		3) pageContext (PageContext) : 다른 내장 객체에 접근 가능한 객체
		4) (★)session (HttpSession) : http 프로토콜이 갖고 있는 단점 보완 ( stateless : 상태유지 X ) ex) 로그인, 사용자 활동기록 ...
		5) application (ServletContext) : 서버측 정보와 서버측 자원에 대한 정보 및 해당 Application의 이벤트 로그를 다루는 객체
		6) out (JspWriter) : 자바 변수를 화면에 출력할 때 사용
						.print("Output Contents") 	: 자바 코드 내에서 html 코드를 입력할 수 있게해주는 함수
		7) page (Object) : 현재 서비스되고 있는 JSP 를 의미
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for(int i = 0; i <= 100; i++){
			out.print(i + " ");
		}
	%>
</body>
</html>