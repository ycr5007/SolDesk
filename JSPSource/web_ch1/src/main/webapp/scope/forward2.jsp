<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setAttribute("name", "홍합탕");
	pageContext.forward("forward3.jsp");
	
	/*
		forward1.jsp 		=====>		form 태그를 통해 'forward2.jsp' 로 값을 전달하며 'forward2.jsp 페이지 요청(request)
		
					form 태그를 거치며, 다음페이지로 내용 전달을 하는 request
		
		forward2.jsp 		=====>		'forward1.jsp' 에서 넘어온 요청에, request 값을 하나 추가(setAttribute)하여 'forward3.jsp' 에 전달
		
					forward2.jsp 가 갖고 있는 request 객체를 물려받는다
		
		forward3.jsp 		=====> 		'forward3.jsp' 에서 전달받은 request 객체를 통해, form 태그에서 넘어온 값 / 'forward2.jsp' 에서 설정한 값 호출 가능
	
		
		§ 	forward1 (request)  ≠ 	forward2 (request) >> 두 request 객체가 같지 않아, Parameter 값은 호출 가능하나, Attribute 값은 호출 불가
			forward2 (request) 	= 	forward3 (request) >> 두 request 객체가 같기 때문에, forward2 에서 갖고 있는 모든 값(Parameter, Attribute) 호출 가능
			
			∴ 모든 페이지는 서로 다른 request 객체를 갖는다. 단, forward 된 경우 forwarding 해준 페이지의 request 객체를 그대로 물려받기 떄문에, 같은 request 객체를 제공받는다.
	*/
%> 

