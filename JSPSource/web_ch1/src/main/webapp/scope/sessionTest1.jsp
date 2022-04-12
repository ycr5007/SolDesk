<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//	String name = "";
	// 세션이 있는지 확인 ( 세션이 없을경우 null )
/*	if(session.getAttribute("name") != null){
		name = (String)session.getAttribute("name");
	}else{
		name = "Session X";
	}	
*/	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <h1>현재 Session 값 : name </h1> -->
	<%
		// 세션 전부 가져오기
		Enumeration<String> sessions = session.getAttributeNames();
		
		String name = "";
		
		while(sessions.hasMoreElements()){
			name = sessions.nextElement();
			if(name != null){
				out.print("<h1>세션 확인 : " + name + " </h1>");
			}
		}
	%>
	<h5>생성여부 : <%=session.isNew() %></h5>
	<h5>세션 ID : <%=session.getId() %></h5>
	<br />
	<hr />
	<h1>Session Test</h1>
	<button type="button" onclick="location.href='session_set.jsp'">Session 값 저장</button>
	<button type="button" onclick="location.href='session_delete.jsp'">Session 값 삭제</button>
	<button type="button" onclick="location.href='session_invalidate.jsp'">Session 값 초기화</button>
</body>
</html>