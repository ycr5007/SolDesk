package board.action;

import java.net.URLEncoder;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardWriteService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardWriteAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDTO dto = new BoardDTO();
		
		UploadUtil util = new UploadUtil();
		HashMap<String, String> data = util.uploadFile(request);
		
		dto.setName(data.get("name"));
		dto.setTitle(data.get("title"));
		dto.setContent(data.get("content"));
		dto.setPassword(data.get("password"));
		dto.setAttach(data.get("attach"));
		
		String page = data.get("page");
		String amount = data.get("amount");
		String criteria = data.get("criteria");
		String keyword = URLEncoder.encode(data.get("keyword"), "UTF-8");
	      
		BoardWriteService service = new BoardWriteService();
		if(!service.insert(dto)) {
			path = "/view/qna_board_write.jsp";
		}
		path += "?page=" + page;
		path += "&amount=" + amount;
		path += "&criteria=" + criteria;
		path += "&keyword=" + keyword;
		  
		return new ActionForward(path);

	}
}
