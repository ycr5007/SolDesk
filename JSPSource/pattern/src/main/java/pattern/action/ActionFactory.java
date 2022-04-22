package pattern.action;

public class ActionFactory {
	private static ActionFactory af;
	
	private ActionFactory() {
		// SingleTon 객체 생성
			/*
				default 생성자 : private, 다른 생성자 X
				getInstance() 메소드 통해 현재 클래스가 갖고 있는 객체 제공
			*/
	};
		
	public static ActionFactory getInstance() {
		if(af == null) {
			af = new ActionFactory();
		}
		return af;
	}
	
	private Action action = null;

	public Action action(String cmd) {
		System.out.println("ActionFactory : " + cmd);
		switch(cmd) {
		case "select" :
			action = new SelectAction();
			break;
		case "insert" :
			action = new InsertAction();
			break;
		case "login" :
			action = new LoginAction();
			break;
		default :
			break;
		}
		
		return action;
	}
}
