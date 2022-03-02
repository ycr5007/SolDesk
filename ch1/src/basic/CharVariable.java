package basic;

// 컴퓨터 내부에서 문자를 표현하기 위한 문자 코드 set : 문자 encoding (약속된 값) <=> 문자 decoding
// ASCII (기본 문자 인코딩 방식) : A (65) , a (97)
	// 영문만 표현이 가능하다
// UNICODE (각 나라의 표준 인코딩) : 1byte 는 ASCII 코드값과 호환

/*
	char(문자형) : 2byte / ' ' 홑따옴표 안에 표현
	String(문자열) : " " 쌍따옴표 안에 표현
*/

public class CharVariable {
	public static void main(String[] args) {
		char ch1 ='A';
		System.out.println("ch1 : " + ch1);

		
		// char ch2 ='AB'; // Invalid character constant ( 문자는 반드시 한 문자만 대입해야 한다. )
		
		char ch2 = 65; // ASCII 코드값과 대조하여 일치하는 문자로 변환
		System.out.println("ch2 : " + ch2);		
	
		int i = 65;
		System.out.println("i : " + i);
		
//		String str1 = "A";
//		String str2 = "Abcdef";
//		System.out.println("str1 : " + str1);
//		System.out.println("str2 : " + str2);
	}
}
