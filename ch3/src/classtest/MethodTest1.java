package classtest;

import java.util.Arrays;

public class MethodTest1 {
/*
	논리타입을 리턴
	매개변수는 없음
	isRedirect()
*/
	boolean isRedirect() {
		return true;
	}
	
/*
	정수타입을 리턴
	2개의 정수 매개변수를 받아, 더하기 한 후 결과값 리턴
	sum()
*/
	int sum(int x, int y) {
		return x + y;
	}
	
/*
	문자타입을 리턴
	매개변수는 없음
	method1()
*/
	char method1() {
		return 'a';
	}
	
/*
	실수타입을 리턴
	2개의 실수값을 입력받음
	divide1()
*/
	float divide1(float x, float y) {
		return x / y;
	}
	double divide2(double x, double y) {
		return x / y;
	}
	
/*
	정수타입의 배열 리턴
	정수타입의 배열을 매개변수로 받아 입력받은 배열을 리턴
	array()
*/
	int[] array(int[] arr) {
		return arr;
	}
	
/*
	문자열(String) 타입을 리턴
	매개변수는 없음, 인사말 반환
	method2()
*/
	String method2() {
		return "쿵짝쿵짝 통통";
	}
	
	
	/*
	 	자바 프로그램 실행 구조
	 		A.java =====> Compile =====> A.class =====> 실행(Run)
	 		
	 		cmd 창 실행
	 			컴파일 : javac A.java =====> A.class 생성
	 			실행 : java A 100 200 300 ... <== main에 매개변수를 줄 수 있음
	 			
	 	Eclipse 에서의 프로그램 실행
	 		A.java 저장 시, 컴파일 및 .class 파일로 변환 완료
	 	
	 		main 매개변수 Run => Run Configurations => arguments에 입력 ( 공백으로 구분 )
	 	
		void main(String[] args) : 메인메소드는 호출이 불가하며, JVM에서 자동으로 찾아 실행
			return : 값 반환 없음 (void)
			Name : main
			매개변수 : String[] args > 
			
		Run(실행) 하는 순간 JVM 에서 main 메소드를 가장 먼저 찾아 실행
	*/
	public static void main(String[] args) {
		MethodTest1 test = new MethodTest1();
		int[] arr = {10, 20, 30};
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		System.out.println("test.isRedirect() : " + test.isRedirect());
		System.out.println("test.sum(10, 20) : " + test.sum(10, 20));
		System.out.println("test.method1() : " + test.method1());
		System.out.println("test.divide1(10.0f, 2.0f) : " + test.divide1(10.0f, 3.0f));
		System.out.println("test.divide2(20, 6) : " + test.divide2(20, 6));
		System.out.println("Arrays.toString(test.array(arr)) : " + Arrays.toString(test.array(arr)));
		System.out.println("test.method2() : " + test.method2());
	}
}
