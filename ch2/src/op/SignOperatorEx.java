package op;

/*
	연산자
		산술, 논리, 조건, 증감, 대입, 부호, 비트
		연산자 우선순위에 따라 동작한다.
		
		산술 > +, -, *, /, %
		부호 > +, - ( ±의 개념 )
		증감 > ++(1 증가), --(1 감소)
		논리 > true, false / 부정연산자 ( ! )
*/

public class SignOperatorEx {
	public static void main(String[] args) {
		
		int x = -100;
		int y = 50;
		
		int result = x + y;
		System.out.println("result : " + result);
		
	}
}
