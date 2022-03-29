package classtest;

public class Calculator3 {
	
	// 멤버 변수 ( 인스턴스, 객체가 갖는 변수 )
	long a, b;
	
	// 멤버 메소드 ( 인스턴스, 객체가 갖는 메소드 )
	long add() {
		return a + b;
	}
	
	long sub() {
		return a - b;
	}
	
	long mul() {
		return a * b;
	}

	double div() {
		return (double)a / b;
	}
	
	// 클래스 메소드 
		/*
			> 모든 객체(인스턴스)에 공통적으로 적용되는 메소드
			> 객체 생성 없이 사용가능
			> 인스턴스 변수, 인스턴스 메소드 사용 불가
		*/
	
//	static long add_err() {
//		add();
//		return a + b;
//	}
	// Cannot make a static reference to the non-static field a : 사용된 변수가 멤버변수이기 때문에, 클래스 메소드에서 사용할 수 없다.
	// Cannot make a static reference to the non-static method add() from the type Calculator3 : 실행하려는 메소드가 멤버메소드이기때문에, 클래스 메소드에서 사용할 수없다.
		// 생성 시기에서 오는 차이 > 클래스 메소드 ( 먼저 메모리에 실림 ), 멤버 메소드 ( new 예약어 이후, 즉 생성여부도 불투명함 )
	
	static long add(long c, long d) {
		return c + d;
	}
	static long sub(long c, long d) {
		return c - d;
	}
	static long mul(long c, long d) {
		return c * d;
	}
	static double div(long c, long d) {
		return (double)c / d;
	}
	
	public static void main(String[] args) {
		
		// 클래스 메소드
		System.out.println("a + b = " + Calculator3.add(10, 5));
		System.out.println("a + b = " + Calculator3.sub(10, 5));
		System.out.println("a + b = " + Calculator3.mul(10, 5));
		System.out.println("a + b = " + Calculator3.div(10, 5));
		
		System.out.println("============================================ Calculator3 객체 생성 ============================================");
		Calculator3 cal = new Calculator3();
		
		cal.a = 10;
		cal.b = 5;
		
		// 멤버 메소드
		System.out.println("a + b = " + cal.add());
		System.out.println("a + b = " + cal.sub());
		System.out.println("a + b = " + cal.mul());
		System.out.println("a + b = " + cal.div());
	}
}
