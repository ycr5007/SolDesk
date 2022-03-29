package op;

public class ArithmeticOperationEx2 {
	public static void main(String[] args) {
	/*
		int x = 1000000;
		int y = 1000000;
		
		int z = x * y;
		System.out.println("x * y = " + z); // -727379968 : int 범위 초과로 인한 비정상적인 값 출력
	*/
		
		long x = 1000000L;
		long y = 1000000L;
		
		long z = x * y;
		System.out.println("x * y = " + z);
	}
}
