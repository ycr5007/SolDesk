package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberModifyService;

@AllArgsConstructor
public class MemberModifyAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		
		MemberModifyService service = new MemberModifyService();
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("loginDto");

		if(new_password.equals(confirm_password)) {
			if(!service.modifyPassword(dto.getUserid(), current_password, new_password)) {
				path = "/view/modifyForm.jsp";
			}
		}else {
			path = "/view/modifyForm.jsp";
		}
		
		return new ActionForward(path);
	}
}
