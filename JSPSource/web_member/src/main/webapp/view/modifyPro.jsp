<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dto.MemberDTO"%>
<%@page import="member.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String current_password = request.getParameter("current_password");
	String new_password = request.getParameter("new_password");
	String confirm_password = request.getParameter("confirm_password");
	
	MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");
	
	String path = "";
	// DB 작업
	if(new_password.equals(confirm_password)){
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		if(dao.modifyPassword(loginDto.getUserid(), current_password, new_password)){
			JdbcUtil.commit(con);
			path = "loginForm.jsp";
			session.invalidate();
		}else{
			JdbcUtil.rollback(con);
			path = "modifyForm.jsp";
		}
		JdbcUtil.close(con);
		response.sendRedirect(path);
	}else {
		out.print("<script>");
		out.print("alert('비밀번호가 일치하지 않습니다');");
		out.print("history.back();");
		out.print("</script>");
	}
%>