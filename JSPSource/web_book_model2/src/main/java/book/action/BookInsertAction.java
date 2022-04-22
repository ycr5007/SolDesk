package book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.dto.BookDTO;
import book.service.BookInsertService;

public class BookInsertAction implements Action{
	
	private String path;
	
	public BookInsertAction(String path) {
		super();
		this.path = path;
	}

	
	// action : View 페이지 
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// jsp 페이지로부터 전달 받은 값 
		BookDTO dto = new BookDTO();
		dto.setCode(Integer.parseInt(request.getParameter("code")));
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));

		
		// DB 작업을 위한 값 전달 및, 맞는 서비스 생성 
		BookInsertService service = new BookInsertService();
		if(!service.insertBook(dto)) {
			path = "/insert.jsp";
		}
		
		
		
		return new ActionForward(path, true);
	}
}
