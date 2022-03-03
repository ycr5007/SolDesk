package condition;

import java.util.Scanner;

/*
	Scanner sc = new Scanner(System.in);
		
	System.out.print("정수 입력 : ");
	int num = sc.nextInt();
	
	System.out.println(num > 0 ? "양수" : num < 0 ? "음수" : "0");
	
	sc.close();
*/

public class IfEx3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수");
		}else {
			System.out.println("음수");
		}
		
		sc.close();
	}
}
