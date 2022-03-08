package access;

public class SingletonEx {
	public static void main(String[] args) {
		
		// public 으로 공개된 메소드를 통해 객체 생성 경로로 접근
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		System.out.println(obj1 == obj2); // true
			// 하나의 인스턴스를 공유한다.
		
		Account account1 = new Account("111", "홍길동", 10000);
		Account account2 = new Account("111", "홍길동", 10000);
		
		System.out.println(account1 == account2); // false
			// new 예약어를 사용했으므로, 각각의 인스턴스로서 서로 다른 값을 갖는다.
	}
}
