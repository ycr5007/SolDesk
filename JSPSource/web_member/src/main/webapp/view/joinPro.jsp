<%@page import="member.dao.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("password"));
	dto.setName(request.getParameter("name"));
	dto.setGender(request.getParameter("gender"));
	dto.setEmail(request.getParameter("email"));
	
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	MemberDTO loginDto = new MemberDTO();
	loginDto.setName(dto.getName());
	loginDto.setUserid(dto.getUserid());
	
	if(dao.register(dto)){
		JdbcUtil.commit(con);
		session.setAttribute("loginDto", loginDto);
		out.print("<script>");
		out.print("alert('회원가입에 성공했습니다.');");
		out.print("location.href = '../index.jsp';");
		out.print("</script>");
	}else{
		JdbcUtil.rollback(con);
		out.print("<script>");
		out.print("alert('회원가입에 실패했습니다.');");
		out.print("history.back();");
		out.print("</script>");
	}
%>