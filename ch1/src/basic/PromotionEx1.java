package basic;

/*
	형변환
		① 자동형변환(Promotion) : 개발자가 신경쓰지 않아도, 자동적으로 형변환이 됨
			> 큰 크기 타입 = 작은 크기 타입 ( ex : long(8byte) = int(4byte) / double(8byte) = float(4byte) ... )
		② 강제형변환(Casting) : 컴파일 오류와 관련이 있어, 신경써서 처리해야 함
		
	자료형의 크기
		byte(1) < short(2) < int(4) < long(8) < float(4) < double(8) / char(2)
*/

public class PromotionEx1 {
	public static void main(String[] args) {
		
		// byte => int (자동형변환 : Promotion)
		byte byteValue = 10;
		int intValue = byteValue;
		
		System.out.println("intValue(byte => int) : " + intValue);
		
		// char => int (자동형변환)
		char charValue = 'A';
		intValue = charValue;
		System.out.println("intValue(char => int) : " + intValue);
	
		// int => long (자동형변환)
		intValue = 500;
		long longValue = intValue;
		System.out.println("longValue(int => long) : " + longValue);

		// int => float (자동형변환)
		float floatValue = intValue;
		System.out.println("floatValue(int => float) : " + floatValue);
		
		// float => double (자동형변환)
		floatValue = 35.2f;
		double doubleValue = floatValue;
		System.out.println("doubleValue(float => double) : " + doubleValue);
		
		// int + double > double (자동형변환) : 두개의 타입이 서로 다를 때 산술연산을 하는 경우 큰 타입을 따라감
		int v1 = 10;
		double d1 = 5.5;
		
		double d2 = v1 + d1;
		// int v2 = v1 + d1; // Type mismatch: cannot convert from double to int : (결과값이 double type 인데 int 변수에 대입하고자 하여, 에러 발생
		System.out.println("d2(int + double) : " + d2);
	}
}
