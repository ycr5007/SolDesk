package condition;

import java.util.Scanner;

/*
	세 개의 정수를 입력 받아 가장 작은 수 출력
	num1 = 35, num2 = 25, num3 = 55
*/

public class MinValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("3개의 정수를 입력해주세요 (공백으로 구분) : ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		int min = x;
		int max = x;
		
		// 최소 값
		if(min > y) {
			min = y;
		}
		if(min > z) {
			min = z;
		}

		// 최대 값
		if(max < y) {
			max = y;
		}
		if(max < z) {
			max = z;
		}
		
		System.out.println("최소 값 : " + min);
		System.out.println("최대 값 : " + max);
		
		sc.close();
	}
}
