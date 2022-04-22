package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberLoginService;

@AllArgsConstructor
public class MemberLoginAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userid = request.getParameter("userid");
		String current_password = request.getParameter("current_password");
		
		MemberLoginService service = new MemberLoginService();
		
		MemberDTO dto = service.loginMember(userid, current_password);
		if(dto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", dto);
		}
		
		return new ActionForward(path);
	}
}
