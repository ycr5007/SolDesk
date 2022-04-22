package board.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardSearchAction implements Action {
//	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		SearchDTO dto = new SearchDTO();
//		
//		dto.setCriteria(request.getParameter("criteria"));
//		dto.setKeyword(request.getParameter("keyword"));
//		
//		BoardSearchService service = new BoardSearchService();
//		List<BoardDTO> list = service.searchBoard(dto);
//		
//		request.setAttribute("list", list);
//		
//		return new ActionForward(path, false);
		return null;
	}
}
