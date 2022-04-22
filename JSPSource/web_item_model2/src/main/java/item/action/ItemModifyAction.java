package item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.service.ItemModifyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemModifyAction implements Action {
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String psize = request.getParameter("psize");
		int price = Integer.parseInt(request.getParameter("price"));
		
		ItemModifyService service = new ItemModifyService();
		
		if(!service.modifyItem(num, psize, price)) {
			path = "/update.jsp";
		}
		
		return new ActionForward(path);
	}
}
