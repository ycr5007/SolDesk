package condition;

/*
	반복문
		어떤 작업이 반복적으로 실행되도록 할 떄 사용
		
	for / while / do ~ while
		for(변수선언; 조건식; 증감식){
			반복할 문장;
		}
		
		① int i = 0; 	: 변수 선언 ( 한번만 실행 )
		② i < 10;		: 조건식 (결과값이 true 일 경우만 for문 실행)
		③ for 블럭 		: 블럭( { } ) 반복할 문장 실행
		④ i++			: 증감식 (반복문이 한번 실행한 후, 증감한다)
		⑤ i < 10;		: 증감 후 조건식 비교
							ː
							ː
		ⓧ i++			: i = 10
		ⓧ i < 10		: 10 < 10 ( false 로 반복문 종료 )
*/

public class ForEx1 {
	public static void main(String[] args) {
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
		
		for(int i = 0; i < 10; i++) {
			System.out.println("안녕하세요");
		}
	}
}
