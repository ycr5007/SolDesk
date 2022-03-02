package basic;

/*
	형변환
		① 자동형변환(Promotion) : 개발자가 신경쓰지 않아도, 자동적으로 형변환이 됨
			> 큰 크기 타입 = 작은 크기 타입 ( ex : long(8byte) = int(4byte) / double(8byte) = float(4byte) ... )
		② 강제형변환(Casting) : 컴파일 오류와 관련이 있어, 신경써서 처리해야 함
			> 작은 크기 타입 = (작은 크기 타입) 큰 크기 타입
*/

public class CastingEx1 {
	public static void main(String[] args) {
		
		// int => byte (강제형변환 : Casting)
		int intValue = 1034;
		System.out.println("intValue : " + intValue);
		byte byteValue = (byte)intValue; // Type mismatch: cannot convert from int to byte : int 값을 byte에 담을 수 없어 에러 발생
		System.out.println("byteValue(int => byte) : " + byteValue); // 강제형변환은 허용되지만, 값 손실이 생길 수 있음 ( 1034 => 10 )
		
		// int => double (자동형변환)
		// double => int (강제형변환)
		int num1 = 123456780;
		double num2 = num1;
		int num3 = (int)num2;
		
		System.out.println("num1 : " + num1 + "\n\tnum2(int => double) : " + num2 + "\n\tnum3(double => int) : " + num3);
	}
}
