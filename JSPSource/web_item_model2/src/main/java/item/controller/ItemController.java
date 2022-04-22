package item.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.action.Action;
import item.action.ActionForward;
import item.action.ItemActionFactory;

@WebServlet("*.do")
public class ItemController extends HttpServlet {
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
		ItemActionFactory iaf = ItemActionFactory.getInstance();
		Action action = iaf.action(command);
		
		ActionForward af = null;
		
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getPath());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
				rd.forward(request, response);
			}
		}
		
	}
}
