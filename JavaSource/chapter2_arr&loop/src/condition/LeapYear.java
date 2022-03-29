package condition;

import java.util.Scanner;

/* 윤년, 평년
	연도 입력받은 후 윤년, 평년인지 출력
	윤년 = 연도를 4로 나눈 나머지가 0 이고, 연도를 100으로 나눈 나머지가 0이 아니거나, 연도를 400으로 나눈 나머지가 0인 연도
*/

public class LeapYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도를 입력하세요 : ");
		int year = sc.nextInt();
		
		if((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0) {
			System.out.println("윤년입니다.");
		}else {
			System.out.println("평년입니다.");
		}
		sc.close();
	}
}
