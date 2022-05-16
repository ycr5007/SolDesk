/**
 * register.jsp
 */

$(function(){
	$(":submit").click(function(e){
		e.preventDefault();
		
		
		let str = "";
		
		// li 태그 정보 수집하기
		$(".uploadResult ul li").each(function(idx, obj){
			var job = $(obj);
			
			str += "<input type='hidden' name='attachList[" + idx + "].uuid' value='" + job.data("uuid") + "'>";	
			str += "<input type='hidden' name='attachList[" + idx + "].uploadPath' value='" + job.data("path") + "'>";	
			str += "<input type='hidden' name='attachList[" + idx + "].fileName' value='" + job.data("filename") + "'>";	
			str += "<input type='hidden' name='attachList[" + idx + "].fileType' value='" + job.data("type") + "'>";	
		});
		
		console.log("form 태그 삽입 전 : " + str);
		
		// 폼 보내기
		$("form").append(str).submit();
	})
	
	// X 버튼 활성화
	$(".uploadResult").on("click", "button", function(){
		// span 태그의 속성 가져오기
		let targetFile = $(this).data("file");
		let type = $(this).data("type");
		
		// span 태그가 속해있는 li 태그 가져오기
		let targetLi = $(this).closest("li");
		
		$.ajax({
			url : '/deleteFile',
			data : {
				fileName : targetFile,
				type : type
			},
			type : 'post',
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
			},
			success : function(result){
				console.log(result);
				$(":file").val("");
				// li 태그 제거
				targetLi.remove();
			}
		})
	})
})