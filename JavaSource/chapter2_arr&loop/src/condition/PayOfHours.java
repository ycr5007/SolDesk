package condition;

import java.util.Scanner;

/*
	사용자로부터 근무시간 입력
	근무시간 중 8시간 까지는 시간당 9800 지급
	8시간을 초과하는 근무시간은 시간당 급여의 1.5배를 추가지급하는 프로그램 작성
*/

public class PayOfHours {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("근무시간 : ");
		int time = sc.nextInt();
		int pay = 0;
		int rate = 9800;
		
		if(time <= 8) {
			pay = time * rate;
		} else{
			pay = (8 * rate) + (int)((time - 8) * (rate * 1.5));
		}
		
		System.out.println("급여는 " + pay + " 원 입니다.");
		
		sc.close();
	}
}
