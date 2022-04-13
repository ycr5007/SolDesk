<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="web2.dto.MemberDTO"%>
<%@page import="web2.dao.JdbcUtil"%>
<%@page import="web2.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);

	List<MemberDTO> list = dao.getList();
%>
    
    
    <%-- NullPointerException : Project Properties >  --%>
<%@ include file="./layout/header.jsp" %>

	<h1>List 페이지</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">name</th>
				<th scope="col">addr</th>
				<th scope="col">email</th>
				<th scope="col">age</th>
			</tr>
		</thead>
		<tbody>
			<%-- Member 정보 출력 (Loop) --%>
			<% for(MemberDTO dto : list){ %>
				<tr style="cursor: pointer" onclick="javascript:location.href='readProcess.jsp?id=<%=dto.getId() %>'">
					<th scope="row"><%=dto.getId() %></th>
					<td><%=dto.getName() %></td>
					<td><%=dto.getAddr() %></td>
					<td><%=dto.getEmail() %></td>
					<td><%=dto.getAge() %></td>
				</tr>
			<%} %>
		</tbody>
	</table>
<%
	JdbcUtil.close(con);
%>
<%@ include file="./layout/footer.jsp" %>