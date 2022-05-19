/**
 * 
 */

$(function(){
	
	let operForm = $("#operForm");
	
	$(":reset").click(function(e){
		e.preventDefault();
		operForm.find("[name='bno']").remove();
		operForm.attr("action", "/board/list");
		operForm.submit();
	})
	
	$(".btn-default").click(function(){
		operForm.submit();
	})
	
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
				
				str += "<li data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.fileType + "'>";
				str += "<a href=\"javascript:showImage(\'" + oriPath + "\')\">";
				str += "<img src='/display?fileName=" + fileCallPath + "'></a>";
				str += "<div>" + obj.fileName;
				str += "</div></li>";
			}else{ // txt 파일
				
				// 다운로드 경로
				let fileCallPath = encodeURIComponent(obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName);
				
				str += "<li data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.fileType + "'>";
				str += "<a href='/download?fileName=" + fileCallPath + "'>";
				str += "<img src='/img/attach.png'></a>";
				str += "<div>" + obj.fileName;
				str += "</div></li>";
				
			}
			console.log("업로드 파일 경로 : " + str)
			
		})
		
		uploadResult.append(str);
	} 
	
	// 첨부파일 가져오기 - 무조건 실행
	$.getJSON({
		url : "getAttachList",
		data : {
			bno : bno
		},
		dataType : 'json',
		success : function(data){
			console.log(data);
			showUploadFile(data);
		}
	})
})