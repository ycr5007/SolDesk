<%@page import="member.dao.MemberDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dao.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	if(dao.deleteMember(userid, password)){
		JdbcUtil.commit(con);
		session.invalidate();
		out.print("<script>");
		out.print("alert('회원탈퇴 되었습니다.');");
		out.print("location.href = '../index.jsp';");
		out.print("</script>");
	}else{
		JdbcUtil.rollback(con);
		out.print("<script>");
		out.print("alert('비밀번호가 일치하지 않습니다.');");
		out.print("history.back();");
		out.print("</script>");
	}
	
%>