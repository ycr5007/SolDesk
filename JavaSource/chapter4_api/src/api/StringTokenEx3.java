package api;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
	사용자로부터 문자열을 입력받아 공백으로 분리된 어절이 몇개인가 출력
*/

public class StringTokenEx3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("문자열을 입력해주세요 (종료 : exit) >");
			String input = sc.nextLine();
			if(input.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			StringTokenizer st = new StringTokenizer(input);
			System.out.println(input + " => " + st.countTokens());
		}
		sc.close();
	}
}
