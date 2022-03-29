package interfacetest;

class OracleDao implements DataAccessObject {
	@Override
	public void select() {
		System.out.println("Oracle DB에서 검색");
	}
	@Override
	public void insert() {
		System.out.println("Oracle DB에서 삽입");
	}
	@Override
	public void updata() {
		System.out.println("Oracle DB에서 수정");
	}
	@Override
	public void delete() {
		System.out.println("Oracle DB에서 삭제");
	}
}

class MySqlDao implements DataAccessObject {
	@Override
	public void select() {
		System.out.println("MySql DB에서 검색");
	}
	@Override
	public void insert() {
		System.out.println("MySql DB에서 삽입");
	}
	@Override
	public void updata() {
		System.out.println("MySql DB에서 수정");
	}
	@Override
	public void delete() {
		System.out.println("MySql DB에서 삭제");
	}
}

public class DaoExample {
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.updata();
		dao.delete();
	}
	
	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}
}
