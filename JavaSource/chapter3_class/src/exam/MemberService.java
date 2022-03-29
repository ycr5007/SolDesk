package exam;

public class MemberService {
	// Property : id, password
	
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// default 생성자
	public MemberService() {	}
	
	// Function
		// login / return - boolean
		// id와 password를 받아 id 가 hong 이고, password 가 12345 인 경우만 true , 이외의 값은 false
	public boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}
		return false;
	}
		// logout / return - void
		// 로그아웃 되었습니다 메세지 출력
	public void logout() {
		System.out.println("로그아웃 되었습니다.");
	}
	
}
