package op;

/*
	변수명 규칙
		- 소문자로 시작(대소문자 구별) > filename, fileName
		- 두 단어가 같이 쓰여질 경우, 첫 단어는 소문자, 두번째부터 대문자로 작성한다.
		- $, _ 문자 사용 가능
		
*/

public class Pencil {
	public static void main(String[] args) {
		int pencil = 534;
		int student = 30;
		
		int result1 = pencil / student;
		int result2 = pencil % student;
		
		System.out.println("인당 : " + result1 + "\n나머지 : " + result2);
	}
}
