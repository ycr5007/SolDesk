package condition;

public class ForEx3 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i = 1; i <=10; i++) {
			sum += i;
			System.out.print(sum + "\t");
		}
		// for 문의 i 는 지역변수로 for 문 블럭내에서만 사용 가능하다.
		// System.out.println(i);
		
		System.out.println();
		sum = 0;
		for(int i = 1; i <=100; i++) {
			sum += i;
			System.out.print(sum + "\t");
		}
	}
}
