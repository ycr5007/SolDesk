package dept.action;

import java.util.Scanner;

import dept.service.DeptDeleteService;
import dept.util.ConsoleUtil;

public class DeptDeleteAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		DeptDeleteService service = new DeptDeleteService();
		ConsoleUtil util = new ConsoleUtil();
		
		if(service.deptDel(util.selectDeptno(sc))) {
			util.successMessage();
		}else {
			util.failMessage();
		}
	}
}
