<%@page import="web2.dto.MemberDTO"%>
<%@page import="web2.dao.MemberDAO"%>
<%@page import="web2.dao.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// list.jsp 에서 넘긴 값 가져오기
	int id = Integer.parseInt(request.getParameter("id"));
	
	// DB 작업
	MemberDAO dao = new MemberDAO(JdbcUtil.getConnection());
	MemberDTO dto = dao.personalMember(id);

	// request 영역에 결과값 담기
	request.setAttribute("MemberDTO", dto);
	
	// 페이지 이동 ( request 객체를 넘기기 위해 forwarding )
		/*
			response.sendRedirect() - scope(request, session)에 값을 담지 않았거나, session에 값을 담는경우
			pageContext.forward() - request.setAttribute() 를 사용하면 무조건 forward 방식으로 이동
		*/
	pageContext.forward("/read.jsp");
%>