package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardDeleteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardDeleteAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");
		
		// 페이지 나누기 한 후 추가
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "UTF-8");
		
		BoardDeleteService service = new BoardDeleteService();
		
		if(!service.deleteBoard(bno, password)) {
			path = "/view/qna_board_pwdCheck.jsp?bno=" + bno;
			path += "&page=" + page;
			path += "&amount=" + amount;
			path += "&criteria=" + criteria;
			path += "&keyword=" + keyword;
		}else {
			path += "?page=" + page;
			path += "&amount=" + amount;
			path += "&criteria=" + criteria;
			path += "&keyword=" + keyword;
		}
		
		return new ActionForward(path);
	}
}
