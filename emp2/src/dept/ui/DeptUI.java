package dept.ui;

import java.util.Scanner;

import dept.action.Action;
import dept.action.DeptAddAction;
import dept.action.DeptDeleteAction;
import dept.action.DeptGetListAction;
import dept.action.DeptGetRowAction;
import dept.action.DeptModifyAction;
import dept.controller.DeptController;

public class DeptUI {
	
	public static void showMenu() {
		System.out.println("──────────────────────────────────────");
		System.out.println("1. 전체부서조회");
		System.out.println("2. 개별부서조회");
		System.out.println("3. 부서 추가");
		System.out.println("4. 부서 삭제");
		System.out.println("5. 부서 지역 수정");
		System.out.println("0. 종료");
		System.out.println("──────────────────────────────────────");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Action action = null;
		DeptController deptController = new DeptController();
		boolean flag = true;
		
		while(flag) {
			showMenu();
			switch(sc.nextLine()) {
				case "1" :
					action = new DeptGetListAction();
					break;
				case "2" :
					action = new DeptGetRowAction();
					break;
				case "3" :
					action = new DeptAddAction();
					break;
				case "4" :
					action = new DeptDeleteAction();
					break;
				case "5" :
					action = new DeptModifyAction();
					break;
				case "0" :
					flag = false;
					System.out.println("프로그램을 종료합니다.");
					break;
				default : 
					System.out.println("잘못된 값입니다.");
					break;
			}
			if(action != null) {
				deptController.processRequest(action, sc);
			}
		}
		sc.close();
	}
	
}
