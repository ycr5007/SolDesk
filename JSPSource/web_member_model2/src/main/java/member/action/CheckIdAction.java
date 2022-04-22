package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.CheckIdService;

public class CheckIdAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		
		String userid = request.getParameter("userid");
		
		CheckIdService service = new CheckIdService();
		PrintWriter out = response.getWriter();
		
		if(service.checkId(userid)) {
			out.print("false");
		}else {
			out.print("true");
		}
		
		return null;
	}
}
