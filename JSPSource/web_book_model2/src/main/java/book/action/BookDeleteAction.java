package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.service.BookDeleteService;

public class BookDeleteAction implements Action{
	
	private String path;

	public BookDeleteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		BookDeleteService service = new BookDeleteService();
		if(!service.deleteBook(code)) {
			path = "/delete.jsp";
		}
		
		return new ActionForward(path);
	}
}
