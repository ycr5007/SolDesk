/**
 * 	Insert Book Script
 */

$(function(){
	$(".btn-primary").click(function(e){
		// submit 기능 중지
		e.preventDefault();
		// code, price 값 확인 ( 숫자인지 여부 )
		
		let code = $("#code");
		let price = $("#price");
		
		/* 
			isNan(val) : 사용자의 입력값이 숫자인지 아닌지 확인
		*/
		
		if(!(/^[0-9]{4}$/.test(code.val()))){
			alert('코드를 확인해주세요.');
			code.select(); // 코드 요소 안에 있는 값을 블록으로 선택
			return;
		}
		
		if(!(/^[0-9]+$/.test(price.val()))){
			alert('가격을 확인해주세요.');
			price.select(); // 가격 요소 안에 있는 값을 블록으로 선택
			return;
		}
		$("#insertForm").submit();
	})
})