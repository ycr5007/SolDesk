package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardReplyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardReplyAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDTO dto = new BoardDTO();
		
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPassword(request.getParameter("password"));
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "UTF-8");
		
		// 댓글 작업 코드
		dto.setRe_ref(Integer.parseInt(request.getParameter("ref")));
		dto.setRe_seq(Integer.parseInt(request.getParameter("seq")));
		dto.setRe_lev(Integer.parseInt(request.getParameter("lev")));
		
		BoardReplyService service = new BoardReplyService();
		if(!service.replyBoard(dto)) {
			path = "/replyView.do?bno=" + dto.getBno();
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
