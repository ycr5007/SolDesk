package op;

import java.util.Scanner;

/*
	사용자로부터 한 달 월급을 입력 받은 후, 한달 월급을 10년동안 저축했을 때 금액 확인하기
*/

public class Salary {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int salary;
		int year = 10;
		
		System.out.print("월급 : ");
		salary = sc.nextInt();
		
		System.out.println("10년 저축 금액 : " + (salary * 12 * year));
		
		sc.close();
	}
}
