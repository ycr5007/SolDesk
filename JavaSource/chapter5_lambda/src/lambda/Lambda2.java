package lambda;

/*
	함수형 인터페이스
		- 단 하나의 추상메소드만 정의 되어 있어야 함 ( default, static 무관 )
			§ 기존의 인터페이스도 추상메소드가 하나만 있다면 함수형 인터페이스로 사용 가능 ∴ Lambda 식 사용 가능
		
	인터페이스 ( 객체 생성 불가 )
		- 구현 클래스 작성 후, 클래스 인스턴스 생성
		- 익명 구현 클래스 방식
*/

// Invalid '@FunctionalInterface' annotation; Lambda2 is not a functional interface
	// 2개 이상의 메소드 선언할 경우, 인터페이스 선에서 에러메세지를 보여줌
@FunctionalInterface // 함수형 인터페이스임을 선언 ( 안전하게 함수형 인터페이스를 구현할 수 있도록 도와줌 )
public interface Lambda2 {
	// 람다식으로 구현할 메소드 선언
//	public void method1(int x);
	public int max(int num1, int num2);
}
