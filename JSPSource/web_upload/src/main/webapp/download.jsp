<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// upload.jsp 에서 지정한 QuertString 값 호출 ( 사용자가 다운로드를 요청한 파일명 가져오기 )
	String fileName = request.getParameter("fileName");


	// 서버 폴더에서 해당 파일 읽어오기
		/*
			파일 입출력
				Stream 	> binary 파일처리 가능 ( 텍스트, 이미지, 동영상 ... 모든 파일 입출력 가능 )
				┌ InputStream (입력) => read(), read(byte[]) => BufferedInputStream
				└ OutputStream (출력)
				
						> 문자기반 파일처리 ( 텍스트만 처리 가능 )
				┌ Reader (입력)
				└ Writer (출력)
		*/
	FileInputStream fis = new FileInputStream("D:\\@Private\\Study\\@SOLDESK\\@Code\\upload\\" + fileName);
	BufferedInputStream bis = new BufferedInputStream(fis);
	
	
	// 브라우저에 파일 붙여 보내기 (응답 : response)
	response.setContentType("application/octet-stream"); // application/octet-stream : 모든 종류의 이진(binary) 데이터
		/*	네트워크 통신 상, 브라우저의 형태/형식 지정 ( MIME type : https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types ) */
	
	// 한글 파일 처리방법 ( Encoding 설정 : URLEncoder )
	fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		/* 다운로드 전 fileName 을 UTF-8 로 인코딩 설정,
			replaceAll() : 파일 중간에 있는 공백 인코딩을 ( 공백 인코딩 : " + " 로 변경 ) 처리해줌
		*/

		/* java.lang.IllegalStateException 에러 해결 ( 다운로드는 정상적으로 작동하나, 에러 발생 ) */
	out.clear(); // 기존에 있는 JSP 내장 OutputStream 제거
	out = pageContext.pushBody(); // 새로운 OutputStream 을 생성하기 위한 작업
		/* JSP를 Servlet으로 변환하는 과정에서 생기는 OutputStream(JspWriter) 때문에, getOutputStream()을 호출하기 전에 JSP 자체의 OutputStream을 제거할 필요가 있음 */
	
	// UUID 를 통한 고유 Key 값을 제거 ( 다운로드 파일에 고유 Key 값이 보여지지 않도록 처리 : subString() )
	String cuttingFileName = fileName.substring(fileName.indexOf("_") + 1);
	
	response.setHeader("Content-Disposition", "attachment;filename=" + cuttingFileName);
		/*	Content-Disposition : Response Body에 오는 컨텐츠의 성향, 특징을 알려주는 속성 ( inline, attachment ... )
				inline : 웹페이지 자체이거나 웹페이지의 일부 ( 웹 페이지 안에서 보여줌 )
				attachment : 다운로드 되거나 로컬에 저장될 용도 ( 반드시 다운로드를 실행 )
					ex ) attachment;filename=?.xxx > filename 값으로 다운로드 작업 처리
				확인방법 :: Network 탭 > response Headers > Content-Disposition : attachment;filename= + [filename]*/
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	int numRead = 0;
	byte[] b = new byte[4096];
	while((numRead = bis.read(b, 0, b.length)) != -1){
		bos.write(b, 0, numRead);
	}
	
	/*
		공백 / 한글 / 특수문자 ... 파일의 경우 에러발생 ( 인코딩 문제 )
			download.jsp
				fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
	
			upload.jsp
				String encodeName = URLEncoder.encode(uploadFile.getName(), "UTF-8");
			
			한글은 대체문자( ' ? ', ' _ ' )로 전환되어 다운로드 진행
			특수문자 및 공백은 파일을 불러오는 과정에서 에러 발생
	*/
	
	bos.flush();
	
	bos.close();
	bis.close();
%>