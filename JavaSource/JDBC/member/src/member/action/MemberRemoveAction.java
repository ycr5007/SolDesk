package member.action;

import java.util.Scanner;

import member.service.MemberRemoveService;
import member.util.ConsoleUtil;

public class MemberRemoveAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil util = new ConsoleUtil();
		MemberRemoveService service = new MemberRemoveService();
		int id = util.selectId(sc);
		
		if(service.removeMember(id)) {
			util.printSuccessMessage();
		}else {
			util.printFailMessage();
		}
	}
}
