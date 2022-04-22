<%@page import="book.dto.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="book.dao.BookDAO"%>
<%@page import="book.dao.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
	Debuging
		① Console 출력
		
		② Tool 사용
			Debug 전용 서버 ( 서버 우클릭 Debug )
			CodeLine ( 우클릭 BreakPoint 설정 )
			break point 로부터 1라인씩 Test 확인 진행 ( F6 ) > Variable Check
			Method 내부 파고들기 ( F5 )
 --%>

<%
	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");
	String criteria = request.getParameter("criteria");
	BookDAO dao = new BookDAO(JdbcUtil.getConnection());
	ArrayList<BookDTO> list = null;
	String path = "";
	
	if(keyword != ""){
		list = dao.searchBook(keyword, criteria);
		path = "list.jsp";
	}
	
	if(list != null){
		request.setAttribute("list", list);
		pageContext.forward(path);
	}else{
		response.sendRedirect("search.jsp");
	}
%>