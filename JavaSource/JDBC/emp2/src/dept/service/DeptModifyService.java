package dept.service;

import static dept.dao.JdbcUtil.*;

import java.sql.Connection;

import dept.dao.DeptDAO;

public class DeptModifyService {
	public boolean deptModi(int deptno, String loc) {
		boolean isSuccess = false;
		Connection con = getConnection();
		DeptDAO dao = new DeptDAO(con);
		if(dao.deptModify(deptno, loc)) {
			commit(con);
			isSuccess = true;
		}else {
			rollback(con);
		}
		return isSuccess;
	}
}
