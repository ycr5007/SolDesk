package item.action;

public class ItemActionFactory {
	private static ItemActionFactory af;
	
	private ItemActionFactory() {}
	
	public static ItemActionFactory getInstance() {
		if(af == null) {
			af = new ItemActionFactory();
		}
		return af;
	}
	
	Action action = null;
	
	public Action action(String cmd) {
		switch(cmd) {
			case "list" :
				action = new ItemListAction("/list.jsp");
				break;
			case "insert" :
				action = new ItemInsertAction("/list.do");
				break;
			case "delete" :
				action = new ItemDeleteAction("/list.do");
				break;
			case "update" :
				action = new ItemModifyAction("/list.do");
				break;
			case "search" :
				action = new ItemSearchAction("/list.jsp");
				break;
			default:
				
				break;
		}
		
		return action;
	}
}
