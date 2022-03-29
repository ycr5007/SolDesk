package emp.service;

import static emp.dao.JdbcUtil.*;

import java.sql.Connection;

import emp.dao.EmpDAO;
import emp.dto.EmpDTO;

public class EmpRowService {

	public EmpDTO getEmpRow(int empno) {
		Connection con = getConnection();
		EmpDAO dao = new EmpDAO(con);
		
		EmpDTO dto = dao.getRow(empno);
		
		close(con);
		
		return dto;
	}
}
