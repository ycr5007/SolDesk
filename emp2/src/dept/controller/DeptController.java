package dept.controller;

import java.util.Scanner;

import dept.action.Action;

public class DeptController {
	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
