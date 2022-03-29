package dept.service;

import static dept.dao.JdbcUtil.*;

import java.sql.Connection;

import dept.dao.DeptDAO;

public class DeptDeleteService {
	public boolean deptDel(int deptno) {
		boolean isSuccess = false;
		Connection con = getConnection();
		
		DeptDAO dao = new DeptDAO(con);
		if(dao.deptDelete(deptno)) {
			commit(con);
			isSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isSuccess;
	}
}
