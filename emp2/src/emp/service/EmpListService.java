package emp.service;

import static emp.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import emp.dao.EmpDAO;
import emp.dto.EmpDTO;

public class EmpListService {
	
	public List<EmpDTO> getEmpList() {
		
		Connection con = getConnection();
		EmpDAO dao = new EmpDAO(con);
		
		List<EmpDTO> list = dao.getList();
		
		// SELECT 문이기 떄문에 트랜잭션 관리 필요 X
		close(con);
		return list;
	}
	
}
