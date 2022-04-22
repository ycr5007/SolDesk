package book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.action.Action;
import book.action.ActionFactory;
import book.action.ActionForward;

@WebServlet("*.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(1, request.getRequestURI().indexOf(".do"));
		System.out.println(request.getRequestURI());
		ActionFactory baf = ActionFactory.getInstance();
		
		Action action/*list action*/ = baf.action(command);
		
		ActionForward af = null;
		
		try {
			af/**/ = action/*list action*/.execute(request, response); // Path / 보내주는 방식 ( redirect / forward )
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// sendRedirect or Forward
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response); // 다음 페이지로 request , response 객체를 넘겨줌
		}
		
		// Select - forward
		// insert / update / delete - redirect
		
		
		/*
		 * Redirect
		 * 		
		 * 			a		-------> 이동			b
		 * 		
		 * 
		 * 			a != b ( a 의 정보를 b 가 받지 못함 )
		 * 
		 * Forward
		 * 			a = 3;
		 * 			a.jsp -------> forward b.jsp
		 * 			b = a;
		 * 
		 * 			a 가 현재 갖고 있는 값, 객체(request)를 b 에도 대입해주는 것
		 * 			
		 * */
	}
}
