package exception;

public class ArithmethicExceptionEx {
	public static void main(String[] args) {
		int num1 = 5, num2 = 0;
		// java.lang.ArithmeticException: / by zero
//		System.out.println(num1 / num2);
		
		try {
			System.out.println(num1 / num2); // 예외발생 코드
		} catch (Exception e) { // 예외가 발생하면 처리하는 코드
			System.out.println("예외 : System.DivideByZeroException");
			e.printStackTrace(); // Exception 내용 출력 ( 개발 단계에서 사용 - 오류 확인 )
			
		}
	}
}
