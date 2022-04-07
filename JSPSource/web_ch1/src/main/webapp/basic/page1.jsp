<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 메소드 선언, 멤버 변수 선언과 동일
	public void jspInit(){
		System.out.println("jspInit()");
	}
	public void jspDestroy(){
		System.out.println("jspDestroy()");
	}
%>
<%
	// 일반 자바 코드 삽입
	System.out.println("_jspService1()");
	int i = 15;
%>
<!-- JSP(Java Server Page) .java 파일 위치 : .metadata\.plugins\org.eclipse.wst.server.core\tmp1\work\Catalina\localhost\web1\org\apache\jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>Insert title here</title>
</head>
<body>
<!-- 
	
				     ┌→		요청		  ─┐
				     │				   ↓
				클라이언트				  서버
				     ↑				   │
				     └─		응답		  ←┘


	Client		: 일반 사용자
	Server	
		Web Application : http 프로토콜로 접근하는 모든 App
		프로그래밍 언어 : Python, Java, PHP, ASP, 닷넷...
		
		JAVA 	> Servlet + JSP
			Server 의 조건 ( 자바 프로그램이 동작하는 프로그램 ( Tomcat ... ) )
				- 운영체제 설치 要 (RINUX) + [http 응답을 위한 서버 ( Apache, nginx... (자바 응답 X) )
					+ WAS (Web Application Server(JAVA))] + DB
 -->

<!-- Project > Builde Path > Java BuildPath > servlet-api.jar / tomcat-api.jar ( 추가 ) -->
<!-- Project > Properties > Project Facets > Java > Runtime(tab) > Apache Tomcat ( Check ) -->


	<h3><%=i /* 선언된 변수를 호출 */%></h3>
	<div></div>
</body>
</html>			