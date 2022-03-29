package api;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
	사용자로부터 문자열을 입력받은 후 구분해서 출력
	예시 ) 아빠/엄마/수연/철수/영희
*/

public class StringTokenEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		while(true) {
			System.out.print("문자열 입력(-종료-입력시 프로그램을 종료합니다.) > ");
			String input = sc.nextLine();
			if(input.equals("종료")) {
				break;
			}
			str = str + "/" + input;
		}
		StringTokenizer st = new StringTokenizer(str, "/");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		sc.close();
	}
}
