package op;

public class ArithmeticOperationEx1 {
	public static void main(String[] args) {
		int v1 = 5;
		int v2 = 2;
		
		int result = v1 + v2;
		System.out.println("v1 + v2 = " + result);
	
		result = v1 - v2;
		System.out.println("v1 - v2 = " + result);
		
		result = v1 * v2;
		System.out.println("v1 * v2 = " + result);
		
		// int 값으로 담고 있기 때문에 , 몫에 대한 값만 저장된다.
		result = v1 / v2;
		System.out.println("v1 / v2 = " + result);
		
		// 나눈 나머지 값을 저장한다.
		result = v1 % v2;
		System.out.println("v1 % v2 = " + result);
		
		// double 강제 형변환 후 나누기연산
		double result2 = (double)v1 / v2;
		System.out.println("(double)v1 / v2 = " + result2);
	}
}
