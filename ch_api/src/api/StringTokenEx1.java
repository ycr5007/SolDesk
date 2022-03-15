package api;

import java.util.StringTokenizer;

/*
	StringTokenizer methods
		
			
							
			boolean				hasMoreTokens(); > Token 이 있는지 확인 (Token : 나누어지는 단위)
*/

public class StringTokenEx1 {
	public static void main(String[] args) {
		StringTokenizer st1 = new StringTokenizer("This is a test");
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
		System.out.println();
		
		StringTokenizer st2 = new StringTokenizer("This/is/a/test", "/"); // 구분자 지정 (default  : " " 공백)
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		System.out.println();
		String exp = "1,김천재,100,100,100|2,박수재,95,80,90|3,이자바,80,90,90";
		StringTokenizer st3 = new StringTokenizer(exp, "|,"); // 구분자가 여러개일 때
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		
	}
}
