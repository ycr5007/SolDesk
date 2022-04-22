<%@page import="java.sql.Connection"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="member.dao.JdbcUtil"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	// form 으로 부터 값 가져오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	Connection con = JdbcUtil.getConnection();
	// DB 작업
	MemberDAO dao = new MemberDAO(con);
	MemberDTO dto = dao.isLogin(userid, password);
	
	JdbcUtil.close(con);
	// 페이지이동
	String path = "";
//	if(dto != null){
//		path = "../index.jsp";
		session.setAttribute("loginDto", dto);
//	}else{
		path = "loginForm.jsp";
//	}
	response.sendRedirect(path);
%>