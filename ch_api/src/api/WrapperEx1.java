package api;

/*
	Wrapper 클래스
		기본형 타입을 객체로 다루기 위한 클래스
		
		byte => Byte
		short => Short
		int => Integer
		long => Long
		float => Float
		double => Double
		boolean => Boolean
		char => Character
		
		생성자 사용 9버전 이후로 불가
			The constructor is deprecated since version 9 ( 11버전 지원 안함 )
		
		Wrapper Class 선언 방법
			WrapperClass name = WrapperClass.valueOf(Type);
*/

public class WrapperEx1 {
	public static void main(String[] args) {
//		Integer i = new Integer(1);
		Integer i1 = Integer.valueOf(100);
		
		int i2 = 100;
		
		System.out.println(i1 == i2); // true; 값이 같기 때문에 true
		System.out.println(i1.doubleValue()); // Wrapper 클래스로, 정수를 객체로 만들경우 포함 메소드 사용 가능
	}
}
