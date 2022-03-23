package dept.service;

import static dept.dao.JdbcUtil.*;

import java.sql.Connection;

import dept.dao.DeptDAO;
import dept.dto.DeptDTO;

public class DeptGetRowService {
	public DeptDTO getRow(int deptno) {
		Connection con = getConnection();
		DeptDAO dao = new DeptDAO(con);
		DeptDTO dto = dao.deptGetRow(deptno);
		
		close(con);
		return dto;
	}
}
