package condition;

/*
	Scanner
		nextInt() > 사용자의 입력값 (int) 과 Enter 값이 Buffer에 저장 ( Int 값만 추출하여 반환 )
		nextLine() > 사용자의 입력값 (String) 과 Enter 값이 Buffer에 저장 ( String 값과 Enter 값을 반환 )
*/

/*
	사칙연산 ( 연산기호를 입력받아 계산 )
*/

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 수 입력 >> ");
		// int num1 = sc.nextInt(); // 사용자 입력 ( int 값 ) >> Buffer ( int 값, Enter 값 ) >> int 반환
		// String num1 = sc.nextLine(); // 문자열 형태이기 때문에 계산된 결과값이 아닌, num1num2 로 나열된다.( + : 연결 ) ex) "1" + "2" = "12"
		int num1 = Integer.parseInt(sc.nextLine()); // Enter가 Buffer에 저장되는것을 방지하기위해 Integer.parseInt(sc.nextLine()); 코드를 사용한다.
		
		System.out.print("두번째 수 입력 >> ");
		// int num2 = sc.nextInt(); // Buffer ( 반환되지 못한 Enter ) >> 사용자 입력 ( int 값 ) >> Buffer ( int 값, Enter 값 ) >> int 반환
		// String num2 = Integer.parseInt(sc.nextLine());
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.print("연산기호( + - * / % ) 중 하나를 입력 >> ");
		String op = sc.nextLine(); // Buffer ( 반환되지 못한 Enter ) >> Enter 반환
		
		
		switch(op) {
			case "+" :
				System.out.println(num1 + " " + op + " " +  num2 + " = " + (num1 + num2));
				break;
			case "-" :
				System.out.println(num1 + " " + op + " " +  num2 + " = " + (num1 - num2));
				break;
			case "*" :
				System.out.println(num1 + " " + op + " " +  num2 + " = " + (num1 * num2));
				break;
			case "/" :
				System.out.println(num1 + " " + op + " " +  num2 + " = " + ((double)num1 / num2));
				break;
			case "%" :
				System.out.println(num1 + " " + op + " " +  num2 + " = " + (num1 % num2));
				break;
		}
		
		sc.close();
	}
}
