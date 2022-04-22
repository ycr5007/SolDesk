package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.dto.BookDTO;
import book.service.BookListService;

public class BookListAction implements Action{
	private String path;
	
	public BookListAction(String path) {
		this.path = path;
	}
	
	
	// list.jsp 아닙니다
	// 현재 페이지 : list.do
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// select * from booktbl; ? 없음
		
		BookListService service = new BookListService();
		
		List<BookDTO> list = service.listAll();
		
		request.setAttribute("list", list); // setter
		
		/*
		 * .setAttribute("name", var);
		 * 
		 * List var = .getAttribute("name");
		 * 
		 * 
		 * session : 전체적용
		 * request : 다음에만 적용
		 * 
		 * */
		
		// session.setAttribute() << JSP 내장객체 
			
		HttpSession session = request.getSession();
		session.setAttribute("name", "홍길동");
		System.out.println((String)session.getAttribute("name"));
		
		// sessionID : 19D686622B8BA8D3D0053CA377C8C133
			// remove : ID 는 바뀌지 않고 그냥 값만 삭제
			// invalidate : 세션이 완전 초기화 ( sessionID 까지 변경됩니다. )
		
		/*
		 * session : 계속 쓸거다
		 * request : 한번만 쓸거다
		 * */
		
		// removeAttribute : 해당 세션이 갖고 있는 속성값만 지우는거
		// invalidate : 세션 아이디 / 갖고 있는 세션을 완전 초기화
		
		return new ActionForward(path, false);
	}
}
