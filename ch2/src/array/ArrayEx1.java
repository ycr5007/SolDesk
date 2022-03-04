package array;

import java.util.Arrays;

/*
	데이터타입 (Data Type)
		기본타입
			정수타입 / 실수타입 / 논리타입
			- 실제 값을 변수 안에 저장 (Stack : 변수와 값 모두 저장)
		
		참조타입
			배열타입 / 열거타입 / 클래스 / 인터페이스
			- 메모리 사용 : 주소를 통해 객체 참조 (Stack : 변수 와 값이 저장된 Heap 주소 저장 / Heap : 각 인덱스 별 값 저장)
	
	JDK (Java Development Kit) > (개발) 목적으로 설치
	JRE (Java Runtime Environment) > 실행
	JVM (Java Virtual Machine) > 프로그램 실행을 위해 OS에서 할당받은 메모리 관리 ( Stack / Heap / Other(메소드 영역) )
		선언하는 자료형에 따라 저장되는 공간이 다름
			> 변수 > Stack
			> 객체, 배열 > Heap (Heap 공간에 저장하는 경우 new 키워드가 필요)
		
		Method 영역
			- JVM 시작할 때 생성
			- 로딩된 클래스 바이트 코드내용을 분석후 저장
			- 모든 스레드가 공유
		
		Heap 영역
			- JVM 시작할 때 생성
			- 객체 / 배열 저장
			- 사용되지 않는 객체는 Garbage Collector 가 자동으로 실행 (메모리 관리를 자동으로 해주므로 따로 관리할 필요가 없음)
				> C 언어의 경우 (Pointer) 등으로 메모리에 직접 관여함
		
		Stack 영역
			- 스레드 별로 생성
			- 메소드 호출할 땜다 Frame을 스택에 추가(push)
			- 메소드 종료하면 Frame 제거(pop)
	
	
	배열 (Array)
		- 같은 타입의 데이터를 연속된 공간에 저장하는 자료구조
			> int score1, score2, score3 ... score30 =========> int score[0] ~ score[29]
		- 각 데이터 저장 위치는 인덱스(0 ~ n)를 부여해 접근
		
		선언 & 생성
			Type name[] = {n1, n2, n3, ...}
			Type name[] = new Type[index size];
				> Type name[]; > 선언 : Stack 영역에 Heap 주소값을 가진 변수명이 저장
				> name[] = new Type[index size]; > Heap 영역에 값을 담을 수 있는 연속된 공간을 부여 받는다
				
*/


public class ArrayEx1 {
	public static void main(String[] args) {
		// 5개의 변수 (정수)
//		int num1 = 3;
//		int num2 = 8;
//		int num3 = 2;
//		int num4 = 4;
//		int num5 = 6;
//		int num6;
		
		// 로컬변수는 반드시 초기화 작업이 필요하다. (Stack에 값이 없기 때문에 에러 발생 : Stack에는 반드시 값이 있어야 한다)
		// System.out.println(num6); // The local variable num6 may not have been initialized : 변수 값이 초기화 되지 않아 에러발생
		
		// 배열로 선언
//		int num[] = {3, 8, 2, 4, 6};
		
		// 배열 선언 및 생성
		int num[] = new int[5];
		System.out.println(num); // num 배열의 주소(Heap 영역의 주소) 값 : [I@7d6f77cc
		System.out.println(num[0]); // index는 0번부터 시작
			// 배열이 생성되면, 모든 값이 기본값으로 초기화 후 저장된다.
		
		// 새로운 값 저장
		num[0] = 78;
		num[2] = 77;
		num[4] = 80;
		
		
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);
		System.out.println(num[3]);
		System.out.println(num[4]);
		/*
			초기화 값
				정수 : 0 / 실수 : 0.0 / boolean : false / Object : null
		*/

		
		// 질문 ...
			// 배열에 toString() 사용하면 모든 배열이 hashcode 값을 반환한다.
				// return getClass().getName() + "@" + Integer.toHexString(hashCode());
			/*
				.getClass().getName()
					[Z = boolean
					[B = byte
					[S = short
					[I = int
					[J = long
					[F = float
					[D = double
					[C = char
					[L = any non-primitives(Object)
			*/
			char[] charArray2 = new char[]{'h','i',' ','t','h','e','r','e'};
			String stringFromCharArray= new String(charArray2);
			System.out.println("stringFromCharArray getClass : \t\t" + stringFromCharArray.getClass());
			System.out.println("stringFromCharArray output : \t\t" + stringFromCharArray);
			System.out.println("charArray getClass : \t\t" + charArray2.getClass());
			System.out.println("charArray output : \t\t" + Arrays.toString(charArray2));
			System.out.println("charArray output : \t\t" + charArray2); // 이건 또 왜이래 ....
			System.out.println(charArray2);
			
			System.out.println("charArray hashcode : \t\t" + charArray2.toString());
	}
}
