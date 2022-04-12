<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 내장객체
		1) request (HttpServletRequest) : 사용자의 요청을 가져올 수 있다. 
			( 서버가 요구한 자료를 클라이언트가 서버에게 전송하며 요청 )	- 요청한 클라이언트의 정보를 모두 담고 있음 ( 전송한 값, IP ... )
		2) response (HttpServletResponse) : 사용자에게 응답할 때 사용
		3) pageContext (PageContext) : 다른 내장 객체에 접근 가능한 객체
					.forward("Page") 	: 실행한 페이지에서 forward 페이지의 내용을 불러온다 ( URL 과 실행되는 페이지 내용이 다름 )
					.include("Page")	: 실행한 페이지에서 include 페이지의 내용을 포함시켜 출력한다
		4) session (HttpSession) 
		
		5) out (JspWriter)
		
		6) application (ServletContext)
			
--%>    


<%--
	JSP 페이지를 include 하는 두 가지 방법
		1) include 지시어(page) 사용
			- Compile 시점에 페이지를 합친다. ( .java 변환 파일이 실행하는 파일 하나만 생긴다 )
		2) PageContext 객체의 include(메소드) 사용
			- Run 시점에 페이지를 합친다. ( .java 변환 파일이 각각 생긴다 )
 --%>
<% pageContext.include("../basic/header.jsp"); %>
<main>
	<h1>PageContext2 Main</h1>
</main>
<% pageContext.include("../basic/footer.jsp"); %>