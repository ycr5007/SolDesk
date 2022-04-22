package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardHitUpdateService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardHitUpadeAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 페이지 나누기 이후 추가
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "UTF-8");
		
		BoardHitUpdateService hitservice = new BoardHitUpdateService();
		hitservice.hit(bno);
		
		path += "?bno=" + bno;
		
		// 페이지 나누기 이후 추가
		path += "&page=" + page;
		path += "&amount=" + amount;
		path += "&criteria=" + criteria;
		path += "&keyword=" + keyword;
		
		return new ActionForward(path);
	}
}
