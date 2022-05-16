package lambda;

public class Lambda2Ex {
	public static void main(String[] args) {
		Lambda2 lambda = null;
//		lambda = x -> System.out.println(x);
//		lambda.method1(100);
//		
//		lambda = x -> System.out.println(x * x);
//		lambda.method1(100);
		
		// 익명 구현 클래스
//		lambda = new Lambda2() {
//			@Override
//			public int max(int num1, int num2) {
//				return num1 > num2 ? num1 : num2;
//			}
//		};
		
//		System.out.println(lambda.max(22, 33));
		
		lambda = (a, b) -> (a < b) ? a : b;
		// The target type of this expression must be a functional interface
			// 인터페이스 메소드 2개 이상인 경우
		System.out.println(lambda.max(15, 20));
	}
}
