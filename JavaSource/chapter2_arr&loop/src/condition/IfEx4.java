package condition;

import java.util.Scanner;

// 숫자를 입력받고 그 숫자가 홀수, 짝수인지 출력

public class IfEx4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if((num % 2) == 0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀수입니다.");
		}
		
		sc.close();
	}
}
