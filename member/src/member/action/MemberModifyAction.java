package member.action;

import java.util.Scanner;

import member.service.MemberModifyService;
import member.util.ConsoleUtil;

public class MemberModifyAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil util = new ConsoleUtil();
		MemberModifyService service = new MemberModifyService();
		int id = util.selectId(sc);
		int menu = util.selectModifyMenu(sc);
		String input = util.modifyMember(sc);
				
		if(service.memberModify(id, menu, input)) {
			util.printSuccessMessage();
		}else {
			util.printFailMessage();
		}
	}
}
