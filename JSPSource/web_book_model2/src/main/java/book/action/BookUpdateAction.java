package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.service.BookUpdateService;

public class BookUpdateAction implements Action{
	
	private String path;
	
	public BookUpdateAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int code = Integer.parseInt(request.getParameter("code"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookUpdateService service = new BookUpdateService();
		
		if(!service.updateBook(code, price)) {
			path = "/update.jsp";
		}
		
		return new ActionForward(path);
	}
}
