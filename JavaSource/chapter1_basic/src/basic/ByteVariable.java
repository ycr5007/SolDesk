package basic;


// 클래스명이 두 개의 단어로 구성된 경우, 각 시작 단어마다 대문자로 표기한다

/*
	변수 : 메모리 저장공간(담는 자료에 따라 타입을 지정)
		: Type > (정수형, 실수형) : 숫자의 크기에 따라서 메모리를 차지하는 공간이 달라짐, 문자형, 논리형 ...
		: 담는 값이 변할 수 있음
*/

	// Compile Error : IDE에서 알려주며, 에러가 있을경우 실행되지 않는다.
		// 코드 끝 기호 세미콜론(;)을 안쓴 경우

/*
	bit : 0 or 1 (on / off)
	byte : 8bit (2^8) > -128 ~ 127
*/

public class ByteVariable {
	public static void main(String[] args) {
		
		// 변수선언 기본구조 : Type Name = Content;
		
		// 정수형 : byte
		byte b1 = 3; // 해당 메모리 주소에 이름(b1)을 naming하여, 값(3)을 호출한다.
		// The value of the local variable b1 is not used ( 변수를 선언했으나 사용하지 않음, 메모리 낭비로 IDE 에서 경고 )

		System.out.println("b1 : " + b1);
		
		byte b2 = -128;
		// byte b3 = 128; // Type mismatch: cannot convert from int to byte ( Type 의 범위 초과 )
		byte b3 = 127;
		System.out.println("b2 : " + b2);
		System.out.println("b3 : " + b3);
	}
}
