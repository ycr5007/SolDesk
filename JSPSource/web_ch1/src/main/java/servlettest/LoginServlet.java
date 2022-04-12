package servlettest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.LoginDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		// 세션영역에 값 담기
		HttpSession session = request.getSession();
		session.setAttribute("login", new LoginDTO(userid, password));
		
		// 페이지 이동
		response.sendRedirect("/servlet/login_result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
