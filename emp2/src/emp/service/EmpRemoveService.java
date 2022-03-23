package emp.service;

import static emp.dao.JdbcUtil.*;

import java.sql.Connection;

import emp.dao.EmpDAO;

public class EmpRemoveService {
	public boolean empRemove(int empno) {
		Connection con = getConnection();
		EmpDAO dao = new EmpDAO(con);
		boolean isRemoveSuccess = false;
		boolean removeResult = dao.deleteEmp(empno);
		if(removeResult) {
			commit(con);
			isRemoveSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isRemoveSuccess;
	}
}
