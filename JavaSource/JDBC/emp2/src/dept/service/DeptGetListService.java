package dept.service;

import static dept.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import dept.dao.DeptDAO;
import dept.dto.DeptDTO;

public class DeptGetListService {
	public List<DeptDTO> getList(){
		Connection con = getConnection();
		DeptDAO dao = new DeptDAO(con);
		List<DeptDTO> list = dao.deptGetList();
		
		close(con);
		return list;
	}
}
