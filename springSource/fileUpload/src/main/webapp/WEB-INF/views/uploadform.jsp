<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	upload
		
		enctype="multipart/form-data" ( upload ) :: DEFAULT > enctype="application/x-www-form-urlencoded"
		
		Spring 파일 업로드

			Commons Fileupload Lib 적용
			servlet-context.xml 수정
				<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />
 -->

	<form action="" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile" id="" multiple="multiple" />
			<!-- multiple : 파일첨부 여러개 -->
		<button>Upload</button>
	</form>
</body>
</html>