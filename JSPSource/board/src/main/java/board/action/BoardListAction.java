package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.dto.PageDTO;
import board.dto.SearchDTO;
import board.service.BoardListService;
import board.service.BoardTotalRowsService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardListAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = 10;
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		SearchDTO dto = new SearchDTO(criteria, keyword, page, amount);
		// 전체 게시물 수
		BoardTotalRowsService countService = new BoardTotalRowsService();
		int totalRows = countService.total(criteria, keyword);
		
		
		
		BoardListService service = new BoardListService();
		List<BoardDTO> list = service.getList(dto);

		PageDTO pageDto = new PageDTO(totalRows, dto);
		
		request.setAttribute("list", list);
		request.setAttribute("pageDto", pageDto);
		
		return new ActionForward(path, false);
	}
}
