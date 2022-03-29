package emp.action;

import java.util.List;
import java.util.Scanner;

import emp.dto.EmpDTO;
import emp.service.EmpListService;
import emp.util.ConsoleUtil;

// SELECT * FROM exam_emp

public class EmpListAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtil util = new ConsoleUtil();
		EmpListService service = new EmpListService();
		List<EmpDTO> list = service.getEmpList();
		
		util.printEmpList(list);
	}
}
