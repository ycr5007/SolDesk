<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 내장객체
		1) request (HttpServletRequest) : 사용자의 요청을 가져올 수 있다. 
			( 서버가 요구한 자료를 클라이언트가 서버에게 전송하며 요청 )	- 요청한 클라이언트의 정보를 모두 담고 있음 ( 전송한 값, IP ... )
		2) response (HttpServletResponse) : 사용자에게 응답할 때 사용
		3) pageContext (PageContext) : 다른 내장 객체에 접근 가능한 객체
					.forward("Page") 	: 실행한 페이지에서 forward 페이지의 내용을 불러온다 ( URL 과 실행되는 페이지 내용이 다름 )
		4) session (HttpSession) 
		
		5) out (JspWriter)
		
		6) application (ServletContext)
			
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.forward("forward1.jsp");
	%>
	<%--
		forward Logic
		
			WAS > Container ( JSP /  Servlet 관리 )
					  req 		  (container)
		Client 		>>>>>>		어떤 응답을 할지 결정 ( Client 의 요청을 해당 페이지에게 내용 / Response 객체를 넘겨줌 )
		
		response( forward 요청 - Client 의 request 와 response 를 넘겨줌 )
		
		Client 는 (최초 request : 원 URL) 한 페이지가 아닌 forward 페이지에 있는 내용을 확인한다. ( 최초 request 받은 페이지 / forward 받은 페이지 모두 같은 정보를 갖고 있음 )
		
			∴ URL 과 Client 가 실제 확인하는 페이지 내용이 일치하지 않음 ... ( ErrorPage, 내부적으로 forward Logic 이 동작 )
			
		구분 방법
			URL ≠ Contents ( forward )
			URL = Contents ( sendRedirect )
	 --%>
	<h1>Forward 안된페이지</h1>
</body>
</html>