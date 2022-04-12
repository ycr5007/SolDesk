package servlettest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/name2")
public class NameServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
			
		// forwarding ( name2 으로부터 요청을 받아, forward 페이지로 요청을 넘겨 출력 )
//		RequestDispatcher rd = request.getRequestDispatcher("/servlet/forward.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect("/servlet/forward.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
