package dept.service;

import static dept.dao.JdbcUtil.*;

import java.sql.Connection;

import dept.dao.DeptDAO;
import dept.dto.DeptDTO;

public class DeptAddService {
	public boolean deptAdd(DeptDTO dto) {
		boolean isSuccess = false;
		Connection con = getConnection();
		DeptDAO dao = new DeptDAO(con);
		boolean result = dao.deptInsert(dto);
		if(result) {
			commit(con);
			isSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isSuccess;
		
	}
}
