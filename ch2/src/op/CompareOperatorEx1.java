package op;

/*
	비교연산자
		==, !=, <, >, >=, <=
*/

public class CompareOperatorEx1 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 10;// int a = 10, b = 20, c = 30; 같은 타입의 변수들은 한 번에 선언 가능
		
		boolean result1 = (num1 == num2);
		boolean result2 = (num1 != num2);
		boolean result3 = (num1 <= num2);
		
		System.out.println("result 1 : " + result1);
		System.out.println("result 2 : " + result2);
		System.out.println("result 3 : " + result3);
		
		char ch1 = 'A';
		char ch2 = 'B';
		int num = 65;
		
		boolean result4 = (ch1 == num);
		System.out.println("result 4 : " + result4);

		boolean result5 = (ch1 < ch2); // character 문자도 비교 가능 (ASCII code
		System.out.println("result 5 : " + result5);
	}
}
