<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//ArrayList<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
%>

<%@ include file="../layout/header.jsp" %>

	<h1>도서 목록 보기</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Code</th>
				<th scope="col">Title</th>
				<th scope="col">Writer</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
			<!-- 도서목록 (반복) -->
			<%--
				<% for(BookDTO dto : list){ %>
					<tr style="cursor: pointer" onclick="javascript:location.href = '#'">
						<th scope="row"><%=dto.getCode() %></th>
						<td><%=dto.getTitle() %></td>
						<td><%=dto.getWriter() %></td>
						<td><%=dto.getPrice() %></td>
					</tr>
				<%} %>
			--%>
			
			<%
				request.getAttribute("list");
			%>
			<c:forEach var="dto" items='${list }'>
				<tr>
					<td>${dto.code }</td>
					<td>${dto.title }</td>
					<td>${dto.writer }</td>
					<td>${dto.price }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<%@ include file="../layout/footer.jsp" %>
