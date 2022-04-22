package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberJoinService;

@AllArgsConstructor
public class MemberJoinAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDTO dto = new MemberDTO();
		
		dto.setUserid(request.getParameter("userid"));
		dto.setName(request.getParameter("name"));
		dto.setPassword(request.getParameter("password"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email"));
		
		MemberDTO loginDto = new MemberDTO();
		loginDto.setUserid(dto.getUserid());
		loginDto.setName(dto.getName());
		MemberJoinService service = new MemberJoinService();
		
		String confirm_password = request.getParameter("confirm_password");
		
		if(dto.getPassword().equals(confirm_password)) {
			if(!service.joinMember(dto)) {
				path = "/view/joinForm.jsp";
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("loginDto", loginDto);
			}
		}else {
			path = "/view/joinForm.jsp";
		}
		
		return new ActionForward(path);
	}	
}
