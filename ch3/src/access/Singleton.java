package access;

/*
	싱글톤 패턴 : 단 하나의 인스턴스만 사용
		> 1. 생성자를 private 로 작성
			- 생성자를 작성하지 않으면, Compiler 에서 default(public) 생성자를 자동으로 생성한다.
		> 2. 클래스 내부에 static 으로 유일한 인스턴스 생성
		> 3. 외부에서 참조 가능한 public 메소드 작성
*/

public class Singleton {
	
	// 1. 생성자를 private 로 작성
	private Singleton()	{}

	// 2. 클래스 내부에 static 으로 유일한 인스턴스를 생성
	private static Singleton singleton = new Singleton();
	
	// 3. 외부에서 참조 가능한 public 메소드 작성
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
