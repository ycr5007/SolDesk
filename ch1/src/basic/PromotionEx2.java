package basic;

public class PromotionEx2 {
	public static void main(String[] args) {
		
		byte b1 = 3;
		short s1 = 10;
		
		// short result = b1 + s1; // Type mismatch: cannot convert from int to short : ( int 보다 작은 타입들을 연산하는 경우 결과가 int 로 돌아오기 때문에 에러 발생 )
		int result = b1 + s1;
		System.out.println("result : " + result);
		
	}
}
