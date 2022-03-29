package condition;

import java.util.Scanner;

/*
	q 가 입력되기 전까지 문자를 입력받기  
*/

public class DoWhileEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String msg = "";
		
		// sc.nextInt(); > 정수 입력 (int 형)
		// sc.nextLine() > 문자열 입력 (String 형)
		
		System.out.print("메세지를 입력해주세요(종료 : q) : ");
		
		do {
			msg = sc.nextLine();
			
			System.out.print("입력한 메세지 >> " + msg + "\n");
		}while(!msg.equals("q"));
		
		System.out.println("프로그램을 종료합니다");
		sc.close();
	}
}
