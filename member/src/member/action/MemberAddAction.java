package member.action;

import java.util.Scanner;

import member.dto.MemberDTO;
import member.service.MemberAddService;
import member.util.ConsoleUtil;

public class MemberAddAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil util = new ConsoleUtil();
		// 사용자에게 입력화면 제시
		MemberDTO insertDto = util.getNewMember(sc);
		// 입력값을 받아 서비스에게 전송
		MemberAddService service = new MemberAddService();
		
		// 서비스의 처리 결과를 화면(Console)에 제시
		if(service.insertMember(insertDto)) {
			util.printAddSuccessMessage();
		}else {
			util.printAddFailMessage();
		}
	}
}
