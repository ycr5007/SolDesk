package basic;

/*
	long : 8byte (2^64) >  -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
*/

public class LongVariable {
	public static void main(String[] args) {
		long var1 = 15;
		System.out.println("var1 : " + var1);
		
		// var1 = 12345678900; // The literal 12345678900 of type int is out of range (int 값의 범위 초과)
			// JAVA에서의 정수 기본 값은 int 형이다 
		var1 = 12345678900L; // long Type 은 컴파일러에게 long type 임을 따로 알려줘야 한다. (int 범위 내의 수치인 경우, 자동형변환을 진행하여 문제없이 출력 가능하다)
	}
}
