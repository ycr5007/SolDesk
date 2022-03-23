package emp.action;

import java.util.Scanner;

import emp.dto.EmpDTO;
import emp.service.EmpModifyService;
import emp.util.ConsoleUtil;

// UPDATE exam_emp SET mgr = ? WHERE empno = ?

public class EmpModifyAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		EmpModifyService service = new EmpModifyService();
		ConsoleUtil util = new ConsoleUtil();
		
		EmpDTO dto = util.printModifyMessage(sc);
		
		boolean result = service.modifyEmp(dto.getEmpno(), dto.getMgr());
		
		if(result) {
			util.printModifySuccessMessage(dto.getEmpno());
		}else {
			util.printModifyFailMessage();
		}
	}
}
