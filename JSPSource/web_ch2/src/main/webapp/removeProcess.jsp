<%@page import="java.sql.Connection"%>
<%@page import="web2.dao.JdbcUtil"%>
<%@page import="web2.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	int id = Integer.parseInt(request.getParameter("id"));
	
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	String path = "";
	if(dao.removeMember(id)){
		System.out.println("삭제 성공");
		JdbcUtil.commit(con);
		path = "list.jsp";
	}else{
		System.out.println("삭제 실패");
		JdbcUtil.rollback(con);
		// forwarding 페이지 이기 때문에 (read.jsp 직접 접근 X) > readProcess.jsp 에 id 값을 전달하여 호출해야 한다.
		path = "readProcess.jsp?id=" + id;
	}
	JdbcUtil.close(con);
	response.sendRedirect(path);
%>