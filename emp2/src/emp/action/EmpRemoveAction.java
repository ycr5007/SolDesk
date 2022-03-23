package emp.action;

import java.util.Scanner;

import emp.service.EmpRemoveService;
import emp.util.ConsoleUtil;

// DELETE FROM exam_emp WHERE empno = ?

public class EmpRemoveAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		EmpRemoveService service = new EmpRemoveService();
		ConsoleUtil util = new ConsoleUtil();
		int empno = util.printRemoveMessage(sc);
		boolean result = service.empRemove(empno);
		
		if(result) {
			util.printRemoveSuccessMessage(empno);
		}else {
			util.printRemoveFailMessage();
		}
	}
}
