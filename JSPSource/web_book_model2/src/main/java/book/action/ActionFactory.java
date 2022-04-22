package book.action;

public class ActionFactory {
	
	private static ActionFactory af;
	
	private ActionFactory() { /* Singleton Pattern */ };
		
	public static ActionFactory getInstance() {
		if(af == null) {
			af = new ActionFactory();
		}
		return af;
	}
	
	// new => getInstance()
	
	/*
	 * 		Scanner a = new Scanner();
	 * 		Scanner b = new Scanner();
	 * 		a != b
	 * 
	 * 		
	 * 		싱글톤패턴
	 * 		Scanner c = Scanner.getInstance();
	 * 		Scanner d = Scanner.getInstance();
	 * 
	 * 		c == d
	 * 
	 * 		new 예약어 사용 불가 => getInstance();
	 * */
	
	Action action = null;
	
	public Action action(String cmd) {
		// 성공시 매개변수, 페이지로 이동
		switch(cmd) {
		case "insert" :
			action = new BookInsertAction("/list.do");
			break;
		case "delete" :
			action = new BookDeleteAction("/list.do");
			break;
		case "search" :
			action = new BookSearchAction("/list.jsp");
			break;
		case "update" :
			action = new BookUpdateAction("/list.do");
			break;
		case "list" :
			action = new BookListAction("/list.jsp");
			break;
		default :
			break;
		}
		
		return action;
		
		/*
		 * 	JSP 파일 form 에서 클릭( ~.do )
		 *  Controller ( *.do 로 지정했기 떄문에 )
		 *  
		 * 
		 * */
	}
}
