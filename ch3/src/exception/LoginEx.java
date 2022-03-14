package exception;

public class LoginEx {
	public static void main(String[] args) {
		
		try {
			login("blue", "112345");
		} catch (NotExistIDException e) {
			e.printStackTrace();
		} catch (WrongPasswordException e) {
			e.printStackTrace();
		}
	}
	
	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {
		// id 가 blue 가 아니라면 NotExistIDException 발생
		if(!(id.equals("blue"))) {
			throw new NotExistIDException("아이디가 존재하지 않습니다.");
		}
		// 아이디가 존재하지 않습니다.
		
		// password 가 12345 가 아니라면 WrongPasswordException 발생
		if(!(password.equals("12345"))) {
			throw new WrongPasswordException("패스워드가 틀립니다.");
		}
		// 패스워드가 틀립니다.
	}
}
