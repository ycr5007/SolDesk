<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");

	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	if(dao.checkId(userid)){
		out.print("false");
	}else{
		out.print("true");
	}
	JdbcUtil.close(con);
%>