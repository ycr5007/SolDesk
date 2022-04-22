/**
 * qna_board_view.jsp Script 
 */

$(function(){
	let formObj = $("#actionForm");

	$("#list").click(function(){
		// 이전 작업
		// location.href = "/list.do";

		// 리스트 이후 작업
		formObj.attr("action", "/list.do");
		formObj.submit();
		
	})
	
	
	$("#delete").click(function(){

		// action 속성 지정
		formObj.attr("action", "/view/qna_board_pwdCheck.jsp");
		
		// submit
		formObj.submit();
	})
	
	$("#modify").click(function(){
		// action 속성 지정
		formObj.attr("action", "/modify.do");
		
		// submit
		formObj.submit();
	})
	
	$("#reply").click(function(){
		// action 속성 지정
		formObj.attr("action", "/replyView.do");
		
		// submit
		formObj.submit();
	})
})