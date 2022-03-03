package op;

/*
	삼항연산자
		조건 ? true 코드 : false 코드
*/

public class ConditionalOperatorEx1 {
	public static void main(String[] args) {
		
		int score = 85;
		char grade = score >= 90 ? 'A' : 'B';
		
		System.out.println(score >= 90 ? 'A' : 'B');
		System.out.println(grade);
		
		// 삼항연산자는 중첩이 가능하다.
		System.out.println(score >= 90 ? 'A' : score >= 80 ? 'B' : 'C');
	}
}
