package emp.action;

import java.util.Scanner;

import emp.dto.EmpDTO;
import emp.service.EmpRowService;
import emp.util.ConsoleUtil;

// SELECT empno, ename, job, hiredate, deptno FROM exam_emp WHERE empno = ?

public class EmpRowAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		EmpRowService service = new EmpRowService();
		ConsoleUtil util = new ConsoleUtil();
		
		int empno = util.printRowMessage(sc);
		EmpDTO dto = service.getEmpRow(empno);
		
		// 최종 출력
		util.printEmpRow(dto);
	}
}
