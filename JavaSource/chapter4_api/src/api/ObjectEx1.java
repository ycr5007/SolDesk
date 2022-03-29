package api;

/*
	Object 클래스
*/

public class ObjectEx1 {
	public static void main(String[] args) {
		
		// 객체 생성 : default 생성자 호출
		Object obj1 = new Object();
		Object obj2 = new Object();
		
	// Object 의 메소드
		
		// equals() : 두 객체간 주소(heap) 비교
			// 단, String 에서는 값의 비교 (Overriding)
		System.out.println(obj1.equals(obj2));
		
		System.out.println(obj1 == obj2); // 주소 비교
		System.out.println("─────────────────────────────────────────────────");
		
		Value value1 = new Value(10);
		Value value2 = new Value(10);
		
		// equals 오버라이딩 전 : false ( 주소비교 )
		// equals 오버라이딩 후 : true ( 값 비교 ) - Value 코드 확인
		System.out.println(value1.equals(value2));
		
		System.out.println(value1.value == value2.value);

		System.out.println("─────────────────────────────────────────────────");
		// toString() : 객체가 저장된 메모리 주소 값 반환
			// 주소값은 활용되지 않기 때문에, 대부분의 Class 는 오버라이딩 하여 유용하게 사용한다.
		
		System.out.println(obj1.toString()); // java.lang.Object@5aaa6d82
		System.out.println(obj2.toString()); // java.lang.Object@73a28541
		System.out.println("─────────────────────────────────────────────────");
		System.out.println(value1.toString()); // 오버라이딩 전 : api.Value@6f75e721 > 오버라이딩 후 : 저장된 값은 10 입니다.
		System.out.println(value2); // 오버라이딩 전 : api.Value@69222c14 > 오버라이딩 후 : 저장된 값은 10 입니다.
	}
}
