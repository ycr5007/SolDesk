package condition;

import java.util.Scanner;

/*
	간단한 은행 계좌 관리 시스템 
*/

public class BankApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int user = 0;
//		int account = 0;
//		int cash = 0;
//		
//		while(true) {
//			System.out.println("------------------------------");
//			System.out.println("1.예금 ｜ 2.출금 ｜ 3.잔고 ｜ 4.종료");
//			System.out.println("------------------------------");
//			System.out.print("선택 >> ");
//			user = sc.nextInt();
//			
//			if(user == 1) {
//				System.out.print("예금 금액을 입력해주세요 >> ");
//				cash = sc.nextInt();
//				account += cash;
//			}else if(user == 2) {
//				System.out.print("출금 금액을 입력해주세요 >> ");
//				cash = sc.nextInt();
//				account -= cash;
//			}else if(user == 3) {
//				System.out.println("현재 잔고는 " + account + " 입니다.");
//			}else if(user == 4) {
//				System.out.println("프로그램을 종료합니다.");
//				break;
//			}else {
//				System.out.println("잘못된 메뉴입니다.");
//			}
//		}
		
		boolean run = true;
		int balance = 0; // 잔고
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금 ｜ 2.출금 ｜ 3.잔고 ｜ 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택 >> ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1 : // 예금액 입력받은 후 잔고에 추가
					System.out.print("예금액 >> ");
					balance += sc.nextInt();
					break;
				case 2 : // 출금액 입력받은 후 잔고에 차감
					System.out.print("출금액 >> ");
					balance -= sc.nextInt();
					break;
				case 3 : // 잔고 조회
					System.out.println("잔고 : " + balance);
					break;
				case 4 :
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;
				default :
					System.out.println("없는 메뉴입니다. 다시 선택해주세요.");
					break;
					
			}
		}
		
		sc.close();
	}
}
