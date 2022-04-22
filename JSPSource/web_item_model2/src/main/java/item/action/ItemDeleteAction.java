package item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.service.ItemDeleteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemDeleteAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		ItemDeleteService service = new ItemDeleteService();
		
		if(!service.deleteItem(num)) {
			path = "/delete.jsp";
		}
		
		
		return new ActionForward(path);
	}
}
