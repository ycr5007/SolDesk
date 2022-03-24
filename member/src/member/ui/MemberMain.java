package member.ui;

import java.util.Scanner;

import member.action.*;
import member.controller.MemberController;

public class MemberMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MemberController controller = new MemberController();
		boolean isStop = false;
		
		do {
			System.out.println("──────────────────── 회원관리 프로그램 ────────────────────");
			System.out.println("1 . 회원등록");
			System.out.println("2 . 회원목록보기");
			System.out.println("3 . 회원정보수정");
			System.out.println("4 . 회원정보삭제");
			System.out.println("0 . 프로그램종료");
			System.out.println("──────────────────────────────────────────────────────");
			
			System.out.print("메뉴 번호 >> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			Action action = null;

			switch(menu) {
				case 1 :
					action = new MemberAddAction();
					break;
				case 0 :
					System.out.println("프로그램을 종료합니다...");
					isStop = !isStop;
					break;
				default :
					
					break;
			}
			
			if(action != null) {
				controller.processRequest(action, sc);
			}
			
		}while(!isStop);
		sc.close();
	}
}
