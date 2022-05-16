/**
 * 
 */

$(function(){
	// 변경 버튼 클릭 시 폼에 있는 데이터를 비동기식으로 전달
	$(".btn-primary").click(function(e){
		e.preventDefault();
		
		let param = {
			userid : 'aaa123', // Session 값 활용
			new_password : $("#new_password").val()
		}
		
		$.ajax({
			url : 'aaa123',
			type : 'put',
			data : JSON.stringify(param),
			contentType : 'application/json',
			success : function(data){
				alert(data);
			},
			error : function(xhr, status, error){
				alert(xhr.responseText);
			}
		})
	})
})