package emp.action;

import java.util.Scanner;

import emp.dto.EmpDTO;
import emp.service.EmpAddService;
import emp.util.ConsoleUtil;

// INSERT INTO exam_emp VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)

public class EmpAddAction implements Action {

	// 4 . Service 객체 생성 및 호출하여 해당 Service 실행
		// 변경 값, service 에게 넘겨줌
	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil util = new ConsoleUtil();
		// ConsoleUtil 에서 값을 받아오기 위해 메소드 호출
		EmpDTO insertDto = util.getNewEmp(sc);
		
		EmpAddService service = new EmpAddService();
		boolean insertResult = service.addEmp(insertDto);
		
		// Service 에서 받은 결과를 통해 최종 결과 메세지 출력
		if(insertResult) {
			util.printAddSuccessMessage(insertDto);
		}else {
			util.printAddFailMessage(insertDto);
		}
	}
	
}
