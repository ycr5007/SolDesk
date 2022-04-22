<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	// request 객체 사용 불가
//	String title = request.getParameter("title");
//	String contents = request.getParameter("contents");
//	String file1 = request.getParameter("file1"); // String 값으로 파일 이름을 가져온다.

// ────────────────────────────────────────────────────────────────────────────────────────────────

	// request 객체 parsing ( request 에서 upload 요청이 있는지 확인 )
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	if(isMultipart){
		// 전송된 파일을 디스크에 저장하기 위한 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 환경설정 파일 ( 사용 x )
//		ServletContext servletContext = this.getServletConfig().getServletContext();
//		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request ( request 객체에서 전송한 데이터를 모두 List에 담음 (text, file ...) )
		List<FileItem> items = upload.parseRequest(request);
		
		// form 데이터 / file 데이터 구분하는 작업
		String fieldName = "", fileName = "", value = "";
		// Process the uploaded items
		Iterator<FileItem> iter = items.iterator();
		
		while (iter.hasNext()) {
			FileItem item = iter.next();
			if (item.isFormField()) { // isFormField (일반 form 데이터인지 확인 (text, email ...))
//				processFormField(item);
				fieldName = item.getFieldName(); // input 태그에서 전송한 name 값
				value = item.getString("UTF-8"); // form 태그에서 입력한 value 값

				out.print("<h3> 일반 form 데이터 : " + fieldName + " : " + value + "</h3>");
			} else {
//				processUploadedFile(item);
				fieldName = item.getFieldName(); // input 태그에서 전송한 name 값
				fileName = item.getName(); // 사용자가 선택한 file 의 이름
				long size = item.getSize(); // file 의 크기
				
				out.print("<h3> Upload File 데이터 : " + fieldName + " : " + fileName + " - " + size + "</h3>");
				
				// Server 에 파일 저장
					// § 보완점 : 사용자가 업로드 한 파일이 동일한 파일명을 서버에 전송할 경우, 기존 파일에 덮어씌우는 문제 발생 ( 파일명 중복처리 필요 (UUID) )
				if(!fileName.isEmpty()){
					// 서버의 파일 저장 경로
					String path = "D:\\@Private\\Study\\@SOLDESK\\@Code\\upload";
					
					// 자바 내장객체 ( java.util : 128bit Unique random 값을 생성 해준다. - 고유 key 값 생성 )
					UUID uuid = UUID.randomUUID();
					
					File uploadFile = new File(path + "\\" + uuid.toString() + "_" + fileName);
						// ce5a3549-27d8-48d5-abe4-5ed08f9b4de7(random ID 값) _ [fileName]
					
					// 실제 디스크에 파일을 저장하는 Code
					item.write(uploadFile);
						
					String encodeName = URLEncoder.encode(uploadFile.getName(), "UTF-8");						
						/* 파일명에 특수문자가 있을 경우, 깨짐 방지 ( 인코딩 한 후, 파일을 업로드 한다. ) */	
					
					
					// download Test
					out.print("<p><a href='download.jsp?fileName=" + encodeName + "'>" + fileName + "</a></p>");
					
				}
			}
		}
		
	}
 %>
