package member.action;

public class MemberActionFactory {
	
	private static MemberActionFactory af;
	
	private MemberActionFactory() { /* Singleton Pattern */ };
		
	public static MemberActionFactory getInstance() {
		if(af == null) {
			af = new MemberActionFactory();
		}
		return af;
	}
	
	Action action = null;
	
	public Action action(String cmd) {
		// 성공시 매개변ㅅ, 페이지로 이동
		switch(cmd) {
		case "login" :
			action = new MemberLoginAction("/view/loginForm.jsp");
			break;
		case "logout" :
			action = new MemberLogoutAction("/index.jsp");
			break;
		case "leave" :
			action = new MemberLeaveAction("/index.jsp");
			break;
		case "modify" :
			action = new MemberModifyAction("/index.jsp");
			break;
		case "join" :
			action = new MemberJoinAction("/index.jsp");
			break;
		case "view/checkId" :
			action = new CheckIdAction();
			break;
		
		default :
			break;
		}
		
		return action;
	}
}
