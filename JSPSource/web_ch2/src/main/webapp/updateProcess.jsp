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
	int id = Integer.parseInt(request.getParameter("id"));
	
	
	// db 작업
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	
	String path = "";
	if(dao.updateMember(id, name, addr, email, age)){
		path = "/list.jsp";
		System.out.println("수정 성공");
		JdbcUtil.commit(con);
	}else{
		path = "/modifyProcess.jsp?id=" + id;
		System.out.println("수정 실패");
		JdbcUtil.rollback(con);
	}
	JdbcUtil.close(con);	
	// 페이지 이동
	response.sendRedirect(path);
%>