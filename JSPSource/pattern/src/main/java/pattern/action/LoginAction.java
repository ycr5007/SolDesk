package pattern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.service.LoginService;

public class LoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Action : login");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		System.out.println("\tID : " + userid);
		System.out.println("\tPassword : " + password);
		
		LoginService service = new LoginService();
		String path = "";
		if(service.login(userid, password)) {
			path = "index.jsp";
		}else {
			path = "loginForm.jsp";
		}
		
		// 각 Action 에서 일이 끝난 후, path / 움직이는 방식 return 필요
		return new ActionForward(path);
	}
}
