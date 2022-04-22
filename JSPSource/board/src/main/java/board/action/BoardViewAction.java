package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.dto.SearchDTO;
import board.service.BoardViewService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardViewAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 페이지 나누기 이후 추가
		SearchDTO searchDto = new SearchDTO();
		searchDto.setPage(Integer.parseInt(request.getParameter("page")));
		searchDto.setAmount(Integer.parseInt(request.getParameter("amount")));
		searchDto.setCriteria(request.getParameter("criteria"));
		searchDto.setKeyword(request.getParameter("keyword"));
		
		
		BoardViewService service = new BoardViewService();
		// 파일 분리 (BoardHitUpadteAction)
//		BoardHitUpdateService hitservice = new BoardHitUpdateService();
//		hitservice.hit(bno);

		BoardDTO dto = service.getDatail(bno);

		if(dto == null) {
			path = "/list.do";
		}
		request.setAttribute("viewDto", dto);

		// 페이지 나누기 이후 추가
		request.setAttribute("searchDto", searchDto);
		
		
		return new ActionForward(path, false);
	}
}
