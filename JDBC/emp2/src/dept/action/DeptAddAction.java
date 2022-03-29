package dept.action;

import java.util.Scanner;

import dept.dto.DeptDTO;
import dept.service.DeptAddService;
import dept.util.ConsoleUtil;

public class DeptAddAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		DeptAddService service = new DeptAddService();
		ConsoleUtil util = new ConsoleUtil();
		DeptDTO dto = util.insertData(sc);
		if(service.deptAdd(dto)) {
			util.successMessage();
		}else {
			util.failMessage();
		}
		
		
	}
}
