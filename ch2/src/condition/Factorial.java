package condition;

import java.util.Scanner;

/*
	숫자를 입력 받은 후 그 숫자의 팩토리얼 구하기
*/

public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력해주세요 : ");
		int user = sc.nextInt();
		int result = 1;
		
		for(int i = user; i > 0; i--) {
			result *= i;
		}
		
		System.out.println(user + " 의 팩토리얼은 : " + result);
		
		result = 1;
		
		for(int i = 1; i <= user; i++) {
			result *= i;
		}
		
		System.out.println(user + " 의 팩토리얼은 : " + result);
		
		sc.close();
	}
}
