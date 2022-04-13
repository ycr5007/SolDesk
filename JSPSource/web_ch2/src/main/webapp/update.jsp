<%@page import="web2.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberDTO dto = (MemberDTO)request.getAttribute("MemberDTO");
%>

<%@ include file="./layout/header.jsp" %>

	<h1>Update 페이지</h1>
	
	<form action="updateProcess.jsp" method="post">
		<div class="form-group row">
			<label for="id" class="col-sm-2 col-form-label">ID</label>
			<div class="col-sm-8">
				<input type="text" name="id" id="id" class="form-control" value="<%=dto.getId() %>" readonly/>
			</div>
		</div>
		<div class="form-group row">
			<label for="name" class="col-sm-2 col-form-label">Name</label>
			<div class="col-sm-8">
				<input type="text" name="name" id="name" class="form-control" value="<%=dto.getName() %>" />
			</div>
		</div>
		<div class="form-group row">
			<label for="addr" class="col-sm-2 col-form-label">Address</label>
			<div class="col-sm-8">
				<input type="text" name="addr" id="addr" class="form-control" value="<%=dto.getAddr() %>" />
			</div>
		</div>
		<div class="form-group row">
			<label for="email" class="col-sm-2 col-form-label">E-Mail</label>
			<div class="col-sm-8">
				<input type="email" name="email" id="email" class="form-control" value="<%=dto.getEmail() %>" />
			</div>
		</div>
		<div class="form-group row">
			<label for="age" class="col-sm-2 col-form-label">Age</label>
			<div class="col-sm-8">
				<input type="text" name="age" id="age" class="form-control" value="<%=dto.getAge() %>" />
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">수정</button>
				<button type="button" class="btn btn-danger" onclick="javascript:location.href = 'list.jsp'">취소</button>
			</div>
		</div>
	</form>
<%@ include file="./layout/footer.jsp" %>