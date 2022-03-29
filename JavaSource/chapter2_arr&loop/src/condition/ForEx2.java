package condition;

public class ForEx2 {
	public static void main(String[] args) {
		
		// 무한 루프 ( 조건과 증감식 확인 )
//			for(int i = 0; i < 3; i--) {
//				System.out.println(i * i);
//			}
		
		// 1 부터 10 까지 출력
		for(int i = 0; i < 10; i++) {
			System.out.print((i + 1) + "\t");
		}
		
		System.out.println();
		
		// 10 부터 1 까지 출력
		for(int i = 10; i > 0; i--) {
			System.out.print(i + "\t");
		}
	}
}
