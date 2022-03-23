package emp.service;

import static emp.dao.JdbcUtil.*;

import java.sql.Connection;

import emp.dao.EmpDAO;
import emp.dto.EmpDTO;

public class EmpAddService {
	
	// 5 . 실제 DB 작업 담당 (성공 여부 반환)
		// 성공 시, Commit / 실패 시, Rollback (개발자가 트랜잭션 관리)
		// DB 작업이 끝났기 때문에 Connection 종료
	public boolean addEmp(EmpDTO newEmp) throws Exception {
		
		boolean isAddSuccess = false;
		
		Connection con = getConnection();
		// DAO 객체 생성 및 DAO 객체의 메소드 실행
		EmpDAO dao = new EmpDAO(con);
		boolean result = dao.insertEmp(newEmp);
		if(result) {
			commit(con);
			isAddSuccess = true;
		}else {
			rollback(con);
		}
		return isAddSuccess;
	}
}
