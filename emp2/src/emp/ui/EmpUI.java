package emp.ui;

import java.util.Scanner;

import emp.action.Action;
import emp.action.EmpAddAction;
import emp.action.EmpListAction;
import emp.action.EmpModifyAction;
import emp.action.EmpRemoveAction;
import emp.action.EmpRowAction;
import emp.controller.EmpController;

public class EmpUI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		EmpController empController = new EmpController();
		
		
		while(flag) {
			System.out.println("─────────────────────────────────────────────────────");
			System.out.println("1 . EMP 전체 조회");
			System.out.println("2 . EMP 사원 조회");
			System.out.println("3 . EMP 사원 수정");
			System.out.println("4 . EMP 사원 삭제");
			System.out.println("5 . EMP 사원 추가");
			System.out.println("0 . 종료");
			System.out.println("─────────────────────────────────────────────────────");
			System.out.println();
			System.out.print("메뉴선택 >> ");
			int no = Integer.parseInt(sc.nextLine());
			
			Action action = null;
			
			// 1 . User 가 선택한 메뉴를 action 객체에 생성
			switch(no) {
				case 1 :
					action = new EmpListAction();
					break;
				case 2 :
					action = new EmpRowAction();
					break;
				case 3 :
					action = new EmpModifyAction();
					break;
				case 4 :
					action = new EmpRemoveAction();
					break;
				case 5 :
					action = new EmpAddAction();
					break;
				case 0 :
					flag = false;
					break;
				default :
					
					break;
			}
			
			
			// 2 . User 선택한 Menu 값이 있다면, Controller 의 processRequest 호출
			if(action != null) {
				empController.processRequest(action, sc);
			}
		}
		sc.close();
	}
}
