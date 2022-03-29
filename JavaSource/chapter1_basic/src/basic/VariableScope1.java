package basic;

/* 
	변수 유효 범위 : 변수를 어디서 선언했는지에 따라 미치는 범위가 다름
		{ } : 블록 안에서 선언
			: 선언된 블록 내에서만 사용이 가능
			1) 클래스 내부에 선언
			2) 메소드 내부에 선언
*/

public class VariableScope1 {
	
	// 클래스 내부에 선언
	// int age;
	
	public static void main(String[] args) {
		// 메소드 내부에서 선언 - " 지역(local)변수 "
		int age = 4;
		int v1 = 3;
		{
			// int age = 3; // Duplicate local variable age : ( 로컬변수 중복으로 인한 에러 )
			v1 = age + 30;
			int v2 = 45;
			System.out.println("v2 : " + v2);
		}
		System.out.println("v1 : " + v1);
		// System.out.println("v2 : " + v2); // v2 cannot be resolved to a variable : ( 메소드 내 블록에서 선언된 로컬변수이기 때문에 블록 밖에서는 확인되지 않아 에러 발생 ) 
	}
	
	public static void print() {
		// System.out.println(age); // age cannot be resolved to a variable : ( main 메소드에서 선언된 변수 age에 대한 정보가 print 메소드에서는 확인되지 않아서 에러 발생 )
	}
	
}
