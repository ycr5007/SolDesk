package condition;

/*
	1 ~ 100 정수 중에서 3의 배수 더하기 ( 단, 9의 배수는 빼기 )
	
	1 ~ 100 정수 중에서 3의 배수와 5의 배수 총합
*/

public class ForEx6 {
	public static void main(String[] args) {
		int ques1 = 0;
		int ques2 = 0;
		
		for(int i = 1; i < 101; i++) {
			if((i % 3) == 0 && (i % 9) != 0) {
				ques1 += i;
			}
		}
		
		System.out.println("ques1 : " + ques1);
		
		for(int i = 1; i < 101; i++) {
			if((i % 3) == 0 || (i % 5) == 0) {
				ques2 += i;
			}
		}
		
		System.out.println("ques2 : " + ques2);
	}
}
