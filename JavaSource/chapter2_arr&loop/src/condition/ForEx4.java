package condition;

public class ForEx4 {
	public static void main(String[] args) {
		// for(int i = 0, j = 0; j < 101 && i < 50; i++, j++) : 변수, 조건, 증감식 모두 다수 사용 가능하다.
		
		// 1 ~ 10 까지 짝수만 출력
//		for(int i = 2; i <= 10; i += 2) {
//			System.out.print(i + "\t");
//		}
		
		for(int i = 1; i <= 10; i++) {
			if((i % 2) == 0) {
				System.out.print(i + "\t");
			}
		}
		
		System.out.println();
		
		// 1 ~ 10 까지 홀수만 출력
//		for(int i = 1; i <= 10; i += 2) {
//			System.out.print(i + "\t");
//		}
		
		for(int i = 1; i <= 10; i++) {
			if((i % 2) == 1) {
				System.out.print(i + "\t");
			}
		}
		
		System.out.println();
		
		// 1 ~ 100 까지 3의 배수만 출력
//		for(int i = 3; i <= 100; i += 3) {
//			System.out.print(i + "\t");
//		}
		
		for(int i = 1; i <= 100; i++) {
			if((i % 3) == 0) {
				System.out.print(i + "\t");
			}
		}
		
		
	}
}
