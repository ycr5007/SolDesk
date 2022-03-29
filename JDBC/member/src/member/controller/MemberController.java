package member.controller;

import java.util.Scanner;

import member.action.Action;

public class MemberController {
	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
