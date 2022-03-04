package condition;

/*
	break / continue
		break > break 실행 후, 반복문 완전 탈출
		continue > continue 실행 후, 해당 반복 내용 생략 
*/

/*
	0 ~ 10 까지의 숫자 중에서 짝수만 출력 (Continue 사용)
*/

public class ContinueEx2 {
	public static void main(String[] args) {
		for(int i = 0; i <= 10; i++) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.println("i : " + i);
		}
		
		/*
		 	1 ~ 100 까지의 숫자 중에서 홀수의 합만 구해서 출력(Continue 사용)
		*/
		int odd  = 0;
		int even = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				even += i;
				continue;
			}
			odd += i;
		}
		System.out.println("홀수의 합 : " + odd);
		System.out.println("짝수의 합 : " + even);
	}
}
