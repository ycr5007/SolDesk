package op;

import java.util.Scanner;

/*
	숫자를 입력받고 그 숫자가 양수, 음수인지 출력
*/

public class ConditionalOperatorEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		System.out.println(num > 0 ? "양수" : num < 0 ? "음수" : "0");
		
		sc.close();
	}
}
