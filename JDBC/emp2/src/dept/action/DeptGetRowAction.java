package dept.action;

import java.util.Scanner;

import dept.dto.DeptDTO;
import dept.service.DeptGetRowService;
import dept.util.ConsoleUtil;

public class DeptGetRowAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		DeptGetRowService service = new DeptGetRowService();
		ConsoleUtil util = new ConsoleUtil();
		DeptDTO dto = service.getRow(util.selectDeptno(sc));
		util.printRow(dto);
	}
}
