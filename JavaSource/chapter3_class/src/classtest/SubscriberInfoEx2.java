package classtest;

/*
	SubscriberInfo 객체배열
*/

public class SubscriberInfoEx2 {
	public static void main(String[] args) {
		
//		int a = null; // Type mismatch: cannot convert from null to int
//		Integer b = null;
			// 기본타입은 null 이 불가, 객체를 통해서만 null 값을 가질 수 있음
			// 초기화 : 정수형(0), 실수형(0.0), 논리형(false) ...
		
		SubscriberInfo info[] = new SubscriberInfo[3];
		String str[] = {"이것은 ", "그것은 ", "저것은 "};
		for(int i = 0; i < info.length; i++) {
			info[i] = new SubscriberInfo(str[i] + "이름", str[i] + "아이디", str[i] + "비밀번호", str[i] + "전화번호", str[i] + "주소");
			System.out.println(info[i].toString());
		}
		System.out.println();
		print(info);
	}
	
	static void print(SubscriberInfo info[]) {
		for(SubscriberInfo s : info	) {
			System.out.println("이름 : " + s.name);
			System.out.println("아이디 : " + s.id);
			System.out.println("비밀번호 : " + s.password);
			System.out.println("전화번호 : " + s.tel);
			System.out.println("주소 : " + s.address);
			System.out.println("======================================");
		}
	}
}
