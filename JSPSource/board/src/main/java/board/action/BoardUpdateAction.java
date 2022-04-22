package board.action;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BookUpdateService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardUpdateAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		UploadUtil uploadUtil = new UploadUtil();
		
		HashMap<String, String> data = uploadUtil.uploadFile(request);
		
		BoardDTO dto = new BoardDTO();
		dto.setBno(Integer.parseInt(data.get("bno")));;
		dto.setName(data.get("name"));
		dto.setTitle(data.get("title"));
		dto.setContent(data.get("content"));
		dto.setPassword(data.get("password"));
		dto.setAttach(data.get("attach"));
		
		// 페이지 나누기 후 추가
		String page = data.get("page");
		String amount = data.get("amount");
		String criteria = data.get("criteria");
		String keyword = URLEncoder.encode(data.get("keyword"), "UTF-8");
		
		
		BookUpdateService service = new BookUpdateService();
		
		if(!service.updateBoard(dto)) {
			path = "/modify.do?bno=" + dto.getBno();
		}else {
			path += "?bno=" + dto.getBno();
		}
		path += "&page=" + page;
		path += "&amount=" + amount;
		path += "&criteria=" + criteria;
		path += "&keyword=" + keyword;
		
		return new ActionForward(path);
	}
}
