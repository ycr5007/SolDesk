package member.action;

import java.util.Scanner;

import member.service.MemberListService;
import member.util.ConsoleUtil;

public class MemberListAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		MemberListService service = new MemberListService();
		ConsoleUtil util = new ConsoleUtil();
		util.printMemberList(service.getMemberList());
	}
}
