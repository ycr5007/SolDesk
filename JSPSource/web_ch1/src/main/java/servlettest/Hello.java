package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	JSP == Servlet ( JSP 파일은 Compile 되면, servlet 으로 전환된다. )

		JSP
			HTML, CSS, JavaScript 사용하기 용이
		
		
		servlet
			순수 Java 파일 ( Java 코드 쓰기가 용이 )
*/


/*
	URL 에서 Project 명 제거하는 방법
		① Server > Modules
		② Path 를 root( / ) 로 설정해준다.
*/

// @WebServlet(" URL ") : 해당 Servlet 를 호출하기 위한 URL
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
		get => doGet
		
		post => doPost
		
			기본적으로 get / post 는 서로 같은 일을 하기 때문에 , post 방식은 doGet을 호출하여 작업한다.
	*/
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		// 응답하는 페이지의 Type 을 설정
		response.setContentType("text/html; charset=utf-8");
		
		// HTML 태그를 작성하기 위한 객체 생성
		PrintWriter out = response.getWriter();

		out.print("<h1>Hello Servlet</h1>");
		out.print("<br>");
		out.print("<h1>안녕히가세요</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
