/**
 * uploadform_ajax 스크립트
 */

$(function(){
	$("#uploadBtn").click(function(){
		console.log("ajax 파일 업로드 호출");
		
		// form 객체 생성
		let formData = new FormData();
		
		// 첨부파일 목록 가져오기
		let inputFile = $("[name='uploadFile']");
		console.log(inputFile);

		let files = inputFile[0].files;
		console.log(files);
		
		// form 객체에 첨부파일들 추가
		for(let i = 0; i < files.length; i++){
			formData.append("uploadFile", files[i]);
		}
		
		// enctype = "multipart/form-data" >> processData · contentType 을 false 로 지정해줌으로써 같은 역할 수행
		
		// form 객체 ajax 전송
		$.ajax({
			url : 'uploadAjax',
			type : 'post',
			processData : false, // processData : false >> 데이터를 일반적인 쿼리 스트링 형태로 변환할 것인지 결정 (Default : true > x-www-form-urlencoded)
			contentType : false, // contentType : false >> (Default : true)
			data : formData,
			dataType : 'json',
			success : function(result){
				// console.log(result);
				showUploadFile(result);
			}
		})
	}) // uploadBtn.click 종료
	
	function showUploadFile(result){
		let uploadResult = $('.uploadResult ul');
		
		let str = "";
		
		$(result).each(function(idx, obj){
			
			if(obj.fileType){ // Image 파일
				console.log(obj.uploadPath);
				console.log(obj.uuid);
				console.log(obj.fileName);
				// 썸네일 이미지 보여주기
					// endcodeURIComponent : (자바스크립트 내장 함수)
				let fileCallPath = encodeURIComponent(obj.uploadPath + "\\s_" + obj.uuid + "_" + obj.fileName);
				console.log(fileCallPath);
				
				// 원본파일 이미지 경로
				let oriPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
				oriPath = oriPath.replace(new RegExp(/\\/g), "/");
				
				str += "<li><a href=\"javascript:showImage(\'" + oriPath + "\')\">";
				str += "<img src='/display?fileName=" + fileCallPath + "'></a>";
				str += "<div>" + obj.fileName + "<span data-file='" + fileCallPath + "' data-type='image'><b> X </b></span>";
				str += "</div></li>";
			}else{ // txt 파일
				
				// 다운로드 경로
				let fileCallPath = encodeURIComponent(obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName);
				
				str += "<li><a href='download?fileName=" + fileCallPath + "'>";
				str += "<img src='/resources/img/attach.png'></a>";
				str += "<div>" + obj.fileName + "<span data-file='" + fileCallPath + "' data-type='file'><b> X </b></span>";
				str += "</div></li>";
				
			}
			
		})
		
		uploadResult.append(str);
	} 
	
	// 첨부파일 삭제 ( X 동작 )
	$(".uploadResult").on("click", "span", function(){
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
			success : function(result){
				console.log(result);
				// li 태그 제거
				targetLi.remove();
			}
		})
	})
	
	
	
	// 이미지 종료
	$(".bigPictureWrapper").on("click", function(){
		$(".bigPicture").animate({width:'0', height:'0'}, 1000);
		setTimeout(function(){
			$(".bigPictureWrapper").hide();
		}, 1000);
	})
})

function showImage(fileCallPath){
	$(".bigPictureWrapper").css("display", "flex").show();
	
	$(".bigPicture").html("<img src='/display?fileName=" + fileCallPath + "'>").animate({width:'100%', height:'100%'}, 1000);
}