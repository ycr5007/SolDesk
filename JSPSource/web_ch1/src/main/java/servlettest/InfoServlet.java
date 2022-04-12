package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// form 에서 넘긴 값들 가져오기
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		String job = request.getParameter("job");
		String[] favorite = request.getParameterValues("favorite");
		String gender = request.getParameter("gender");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<p> userID : " + userId + "</p>");
		out.print("<p> password : " + password + "</p>");
		out.print("<p> job : " + job + "</p>");
		out.print("<p> favorite <ul>");
		for(int i = 0; i < favorite.length; i++) {
			out.print("<li>" + favorite[i] + "</li>");
		}
		out.print("</ul></p>");
		out.print("<p>gender : " + gender + "</p>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
