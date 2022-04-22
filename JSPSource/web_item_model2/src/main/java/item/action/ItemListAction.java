package item.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.dto.ItemDTO;
import item.service.ItemListService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemListAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ItemListService service = new ItemListService();
		
		List<ItemDTO> list = service.getList();
		
		request.setAttribute("list", list);
		return new ActionForward(path, false);
	}
}
