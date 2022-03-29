package emp.service;

import static emp.dao.JdbcUtil.*;

import java.sql.Connection;

import emp.dao.EmpDAO;

public class EmpModifyService {
	
	public boolean modifyEmp(int empno, int mgr) {
		boolean isModifySuccess = false;
		Connection con = getConnection();
		EmpDAO dao = new EmpDAO(con);
		
		boolean modifyResult = dao.updateMgr(empno, mgr);
		if(modifyResult) {
			commit(con);
			isModifySuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isModifySuccess;
	}
}
