<%@page import="java.sql.Connection"%>
<%@page import="web2.dao.MemberDAO"%>
<%@page import="web2.dao.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");	
	// form 입력값 가져오기
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String email = request.getParameter("email");
	int age = Integer.parseInt(request.getParameter("age"));
	
	
	// db 작업
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	
	String path = "";
	if(dao.insertMember(name, addr, email, age)){
		path = "/list.jsp";
		System.out.println("삽입 성공");
		JdbcUtil.commit(con);
	}else{
		path = "/insert.jsp";
		System.out.println("삽입 실패");
		JdbcUtil.rollback(con);
	}
	JdbcUtil.close(con);	
	// 페이지 이동
	response.sendRedirect(path);
%>