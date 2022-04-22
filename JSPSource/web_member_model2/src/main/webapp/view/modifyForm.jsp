<%@page import="member.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<form id="modifyform" action="/modify.do" method="post">
	<div class="card"  style="width: 40rem;margin:40px auto;">	
		<div class="card-header">
	    	<h4>비밀번호 변경</h4>
	  	</div>
	 	<div class="card-body">	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="current_password" id="current_password" class="form-control" placeholder="현재 비밀번호" autofocus="autofocus"/>
					<small id="current_password" class="text-info"></small>	
				</div>
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="new_password" id = "new_password" class="form-control" placeholder="새 비밀번호"/>
					<small id="new_password" class="text-info"></small>
				</div>	
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="confirm_password" id = "confirm_password" class="form-control" placeholder="새 비밀번호 확인"/>
					<small id="confirm_password" class="text-info"></small>
				</div>	
			</div>	
			<div class="form-group text-center">		
				<button type="submit" class="btn btn-primary" name="modifyform">수정</button>
			    <button type="reset" class="btn btn-secondary" id="modifycancel">취소</button>		
			</div>
		</div>
	</div>		
</form>
<%
	// MemberDTO dto = (MemberDTO)session.getAttribute("loginDto");
%>
<script>
	let name = '${loginDto.name}';
</script>
<script src="../js/menu.js"></script>
<script src="../js/command.js"></script>
<script>
	// script (DOM 이 모두 load 된 후에 확정적으로 스크립트를 동작시키는 방법)
		// > DOM 이 동적으로 추가되는 경우나 이미 생성된 경우 사용
//	window.onload = function(){}
	
	// JQuery
//	$(document).ready(function(){})
//	$(function(){})

	// body 에서 모든 문서(DOM)이 로드 되는 경우에는 사용하지 않아도 스크립트가 정상적으로 작동한다.

	$(function(){
		$("#modify").detach();
	})
</script>
<script src="../js/modifyRegex.js"></script>
<%@ include file="../layout/footer.jsp" %>