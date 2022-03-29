package dept.action;

import java.util.Scanner;

import dept.service.DeptModifyService;
import dept.util.ConsoleUtil;

public class DeptModifyAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		DeptModifyService service = new DeptModifyService();
		ConsoleUtil util = new ConsoleUtil();
		
		
		
		if(service.deptModi(util.selectDeptno(sc), util.selectLoc(sc))) {
			util.successMessage();
		}else {
			util.failMessage();
		}
			
	}
}
