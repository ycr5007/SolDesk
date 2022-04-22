<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- 
	File 전송
		getParameter => String 형식( 파일 이름을 반환 / 파일 자체를 반환하지 않음 )
			∴ request 객체로 파일전송 불가
		
	방법
		① Servlet 을 이용하는 방법
		② 외부 라이브러리를 이용하는 방법 (apache commons-fileupload)
			https://commons.apache.org/proper/commons-fileupload/
			
			form 태그 enctype 속성 지정 필요 : multipart/form-data 으로 변경 ( default : application/x-www-form-urlencoded )
				multipart/form-data : request.getParameter 사용 불가
 --%>
</head>
<body>
	<form action="upload.jsp" method="post" enctype="multipart/form-data" >
		<div>
			<label> 제목
				<input type="text" name="title" id="title" />
			</label>
		</div>
		<div>
			<label> 내용
				<textarea name="contents" id="contents" cols="30" rows="10"></textarea>
			</label>
		</div>
		<div>
			<label>첨부파일</label>
			<input type="file" name="file1" id="file1" />
		</div>
		<div>
			<input type="submit" value="send" />
		</div>
	</form>
</body>
</html>