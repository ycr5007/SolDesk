package op;

/*
	논리 연산자
		&& (AND) : 논리 곱
		|| (OR) : 논리 합
		! (NOT) : 부정
	
*/

public class LogicalOperatorEx1 {
	public static void main(String[] args) {
		boolean and_result = (5 > 3) && (5 > 2);
		System.out.println("AND_result : " + and_result);

		boolean or_result = (5 > 3) || (5 > 2); // Dead code ( 상수값으로 이미 True 값이 확인되기 떄문에 뒤의 논리는 실행하지 않는다 )
		System.out.println("OR_result : " + or_result);
	}
}
