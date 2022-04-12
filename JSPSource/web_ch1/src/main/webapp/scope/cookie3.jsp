<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	Cookie[] cookies = request.getCookies();
	String language = "", ko = "한국어", en = "영어", ok = "설정";
	for(Cookie c : cookies){
		if(c.getName().equals("language")){
			language = c.getValue();
			if(c.getValue().equals("korea")){
				ko = "한국어";
				en = "영어";
				ok = "설정";
			}else if(c.getValue().equals("english")){
				ko = "Korean";
				en = "English";
				ok = "Setting";
			}
		}
	}
--%>

<%
	// 쿠키 정보 가지고 오기
	// 쿠키 정보가 없다면 기본 값은 korea 설정
	
	String language = "korea";
	String cookie = request.getHeader("Cookie");
	if(cookie != null){
		Cookie cookies[] = request.getCookies();
		
		for(Cookie  c : cookies){
			if(c.getName().equals("language")){
				language = c.getValue();
			}
		}
	}
	String ko = "", en = "", ok = "";
	if(language.equals("korea")){
		ko = "한국어";
		en = "영어";
		ok = "설정";
	}else if(language.equals("english")){
		ko = "Korean";
		en = "English";
		ok = "Setting";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style="text-align: right"><%=language %></p>
	<%
		if(language.equals("korea")){
			out.print("<h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>");
		}else{
			out.print("<h3>Hello. This is Cookie example.</h3>");
		}
	%>
	<form action="cookie_set.jsp" method="post">
		<input type="radio" name="language" value="korea" <% if(language.equals("korea")){ %> checked <% } %>/><%=ko %>
		<input type="radio" name="language" value="english" <% if(language.equals("english")){ %> checked <% } %>/><%=en %>
		<input type="submit" value=<%=ok %> />
	</form>
</body>
</html>