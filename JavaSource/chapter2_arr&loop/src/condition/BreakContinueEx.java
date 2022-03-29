package condition;

import java.util.Scanner;

/*
	continue 와 break 는 한 반복문 내에서 같이 사용이 가능하다. ( 조건으로 구분 ) 
*/

public class BreakContinueEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		
		while(true) {
			System.out.println("(1) . square");
			System.out.println("(2) . square root");
			System.out.println("(3) . log");
			System.out.print("메뉴를 선택해주세요 ( 종료 : 0 ) >> ");
			
//			String num = sc.nextLine();
//			menu = Integer.parseInt(num);
			menu = sc.nextInt();
			
			if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(!(1 <= menu && menu <= 3)) {
				System.out.println("잘못된 메뉴를 선택했습니다. ( 종료 : 0 )");
				continue;
			}
			System.out.println("선택하신 메뉴는 " + menu + " 입니다.");
			
		}
		sc.close();
	}
}
