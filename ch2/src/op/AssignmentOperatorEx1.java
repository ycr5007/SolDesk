package op;

/*
	복합대입 연산자
*/

public class AssignmentOperatorEx1 {
	public static void main(String[] args) {
		int result = 10;
		
		// result = result + 10;
		result += 10;
		System.out.println("result : " + result);
		
		// result = result - 5;
		result -= 5;
		System.out.println("result : " + result);
		
		// result = result * 3;
		result *= 3;
		System.out.println("result : " + result);
		
		// result = result / 5;
		result /= 5;
		System.out.println("result : " + result);
		
		// result = result % 3;
		result %= 3;
		System.out.println("result : " + result);
	}
}
