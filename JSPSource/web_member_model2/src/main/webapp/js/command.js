/**
 * 로그인 성공 후 생성된 버튼의 이벤트 관리
 */
$(function(){
	$('#logout').click(function(){
		location.href = "/logout.do";
	})
	
	$('#modify').click(function(){
		location.href = "/view/modifyForm.jsp";
	})

	$('#leave').click(function(){
		location.href = "../view/leaveForm.jsp";
	}) 
})