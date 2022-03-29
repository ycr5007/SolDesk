package basic;

/*
	short : 2byte (2^16) > -32,768 ~ 32,767
*/

public class ShortVariable {
	public static void main(String[] args) {
		
		// 프로그램은 위에서부터 아래로, 순서대로 실행된다.
		
		short s1 = 200;
		System.out.println("s1 : " + s1);
		
		s1 = 350;
		System.out.println("s1 : " + s1);
		
		byte b1 = 12;
		short s2 = 25;
		// 문자열 + 정수 > "+" 는 연결의 의미로 사용됨 (변수 앞, 뒤 쪽으로 문자열("")이 존재하는 경우)
		// 정수 + 정수 > "+"는 산술연산의 의미로 사용됨
		System.out.println("b1 + s2 : " + (b1 + s2));
		

	}
}
