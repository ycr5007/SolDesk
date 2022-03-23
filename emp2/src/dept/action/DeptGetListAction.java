package dept.action;

import java.util.List;
import java.util.Scanner;

import dept.dto.DeptDTO;
import dept.service.DeptGetListService;
import dept.util.ConsoleUtil;

public class DeptGetListAction implements Action {
	@Override
	public void execute(Scanner sc) throws Exception {
		DeptGetListService service = new DeptGetListService();
		List<DeptDTO> list = service.getList();
		ConsoleUtil util = new ConsoleUtil();
		util.printList(list);
	}
}
