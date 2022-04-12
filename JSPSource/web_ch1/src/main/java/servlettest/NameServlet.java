package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/name")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		// post 방식으로 올 경우 한글이 깨지기 때문에 Encoding 을 설정해주어야 한다.
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>" + request.getParameter("username") + "</h1>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
