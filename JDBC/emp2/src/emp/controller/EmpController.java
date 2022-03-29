package emp.controller;

import java.util.Scanner;

import emp.action.Action;

public class EmpController {
	
	// 3 . UI 로부터 호출되어, UI 에서 넘어온 Action 을 execute() 호출
	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
