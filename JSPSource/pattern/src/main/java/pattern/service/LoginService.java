package pattern.service;

public class LoginService {
	public boolean login(String userid, String password) {
		System.out.println("Service : login");
		if(userid.equals("hong123") && password.equals("123")) {
			System.out.println("\tDAO 성공");
			return true;
		}else {
			System.out.println("\tDAO 실패");
		}
		return false;
	}
}
