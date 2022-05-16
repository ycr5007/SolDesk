/**
 * 
 */

$(function(){
	// 입력 버튼 클릭시 폼에 있는 데이터를 비동기식으로 전달
	$(".btn-primary").click(function(e){
		// 버튼 기능 중지
		e.preventDefault();
		
		// JSON으로 변환할 객체 생성
		let param = {
			userid : $("#userid").val(),
			password : $("#password").val(),
			name : $("#name").val(),
			gender : $("[type='radio']:checked").val(),
			email : $("#email").val()
		};
		
		// ajax 통신
		$.ajax({
			url : 'new',
			type : 'post',
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