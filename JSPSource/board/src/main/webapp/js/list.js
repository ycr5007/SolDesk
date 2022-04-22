/**
 * qna_board_list.jsp Script
 */

$(function(){
	// text 엔터 금지
	$(":text").keydown(function(e){
		if(e.keyCode == 13) {
			e.preventDefault();
		}
	})
	
	$(".btn-primary").click(function(){
		// criteria 의 value 가 n 일 경우 경고메세지
		if($('#criteria').val() == 'n'){
			alert("항목을 선택해주세요.");
			return false;;
		}
		
		// keyword 의 value 가 "" 일 경우 경고메세지
		if($('#keyword').val() == ''){
			alert("키워드를 입력해주세요.");
			return false;
		}
		
		$('#search').find("[name='page']").val(1);
		// form submit
		$('#search').submit();
	})
	// 페이지 나누기 이동
		// 페이지 나누기 정보를 가지고 있는 폼 가져오기
	let actionForm = $("#actionForm");
	
	// 글 제목 클릭시 actionForm 전송
	$(".move").click(function(e){
		// a 태그 중지
		e.preventDefault();
		
		let bno = $(this).attr("href");
		
		actionForm.append("<input type='hidden' name='bno' value='" + bno + "' />");
		
		// actionForm 의 action 새로 지정 => /hitUpdate.do
		actionForm.attr("action", "/hitUpdate.do");
		

		// href 의 값을 가져온 후 actionForm 안의 bno 값 변경		
		actionForm.find("[name='bno']").val(bno);

		// actionForm.submit();
		actionForm.submit();
	})
	
	
	// 페이지 번호 또는 이전 / 다음 클릭 시 actionForm 보내기
	$(".page-link").click(function(e){
		// a 태그 기능 중지
		e.preventDefault();
		
		// a 태그의 href 속성이 갖는 값을 가져오기
		let page = $(this).attr("href");
		
		// 페이지 초과 시, 마지막 페이지로 변경해주는 작업
		if(page > totalPage){
			page = totalPage;
		}
		
		// actionForm 안의 page 번호를 교체
		actionForm.find("[name='page']").val(page);
		
		actionForm.find("[name='bno']").remove();
		actionForm.attr("action", "/list.do");
		
		// actionForm 보내기
		actionForm.submit();
	})
	
	// 새 글 작성시 페이지 정보 보내야함
	$(".btn-success").click(function(){
		
		actionForm.attr("action", "/view/qna_board_write.jsp");
		actionForm.attr("method", "post");
		
		actionForm.submit();
	})
	
		
})

