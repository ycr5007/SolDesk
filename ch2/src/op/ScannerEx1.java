package op;

import java.util.Scanner;

/*
	Scanner (util)
		사용자로부터 값을 입력받기 위한 객체
		
			import java.util.Scanner;
		
			Scanner sc = new Scanner(System.in); > 객체 생성
			
			sc.nextInt(); > 정수 값 입력 받음
			
			sc.close(); > 객체 종료
	
	
	System.in : 키보드로부터 입력을 받는다
	System.out : 모니터로 출력을 한다
*/

public class ScannerEx1 {
	public static void main(String[] args) {
		// 키보드로부터 입력을 받고 싶을 때
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		// 사용자에게 정수를 입력받는 부분 > 자료형이 일치하지 않을 시 exception 발생 
		int num = sc.nextInt();
		
		System.out.println("입력한 숫자는 " + num);
		
		sc.close();
	}
}
