<%@page import="book.dto.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="book.dao.BookDAO"%>
<%@page import="book.dao.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");
	BookDAO dao = new BookDAO(JdbcUtil.getConnection());
	ArrayList<BookDTO> list = null;
	String path = "";
	
	if(keyword != ""){
		switch(request.getParameter("criteria")){
			case "code" :
				list = dao.searchBook(Integer.parseInt(keyword));
				path = "list.jsp";
				break;
			case "writer" :
				list = dao.searchBook(keyword);
				path = "list.jsp";
				break;
		}
	}
	if(list != null){
		request.setAttribute("list", list);
		pageContext.forward(path);
	}else{
		response.sendRedirect("search.jsp");
	}
%>