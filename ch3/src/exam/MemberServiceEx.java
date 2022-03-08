package exam;

import java.util.Scanner;

//MemberService 객체 생성
		// login 메소드 호출
		// 메소드 호출 결과를 받아 true 인 경우, "로그인 되었습니다." 메세지 출력 후, logout 메소드 호출
		//					false 인 경우, "id 또는 password 가 올바르지 않습니다" 메세지 출력

public class MemberServiceEx {
	public static void main(String[] args) throws InterruptedException {
		
		MemberService service = new MemberService();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("id : ");
		String id = sc.nextLine();
		service.setId(id);
		System.out.print("pw : ");
		String password = sc.nextLine();
		service.setPassword(password);
		
		if(service.login(id, password)) {
			System.out.println(service.getId() + "님이 로그인 되었습니다.");
			Thread.sleep(1000);
			service.logout();
		}else {
			System.out.println("id 또는 password 가 올바르지 않습니다.");
		}
		
		sc.close();
	}
}
