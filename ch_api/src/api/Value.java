package api;

public class Value {
	int value;

	public Value(int value) {
		this.value = value;
	}
	
	// 주소비교가 아닌 값 비교로 오버라이딩
	@Override
	public boolean equals(Object obj) {
		// obj instanceof Value : obj가 Value 객체로 변환할 수 있는지 확인
		if(obj instanceof Value) {
			Value v = (Value) obj; // obj 가 Value 객체로 확인되어, 강제 형변환 실행
			
			// 값 비교 코드
			if(this.value == v.value) {
				return true;
			}
		}
		return false;
	}
	
	// 클래스의 해시코드값을 구하는 메소드 ( Java 에서는 메모리 접근 사용 X > 다른 용도로 오버라이딩 하여 주로 사용한다 )
//	public String toString() {
//  	return getClass().getName() + "@" + Integer.toHexString(hashCode());
//	}
	@Override
	public String toString() {
		return "저장된 값은 " + value + " 입니다.";
	}
	

	
}
