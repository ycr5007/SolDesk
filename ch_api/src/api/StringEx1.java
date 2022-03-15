package api;

public class StringEx1 {
	public static void main(String[] args) {
		
		// 문자열 만드는 2가지 방법 ( 메모리 상에서 차이가 생김 )
			// 문자열 리터럴을 지정 > String str = "String";
				// 상수풀 메모리에 저장
			// String 클래스 생성자 이용 > String str = new String("String");
				// new 예약어로 인해, 힙 메모리에 저장
		
		String str1 = "Hello";
		// 0x100 = Hello 문자열 저장
		String str2 = "Hello";
		// 메모리를 검사 후, Hello 문자열이 있으면 같은 주소 (0x100)을 찾아 가리킴 ( 상수풀 메모리에서 검색 )
		String str3 = new String("Hello");
		// 0x300 주소에 저장
		String str4 = new String("Hello");
		// 0x400 주소에 저장, 기존에 있는 문자열을 찾지 않고 다른 주소에 저장
		
		System.out.println(str1 == str2); // 0x100 동일한 주소로 true 반환
		System.out.println(str3 == str4); // 0x300 - 0x400 으로 다른 주소이기 때문에 false 반환
		
		// String 에서의 equals 는 내용비교로 변경되어 있는 상태
		
			//		String 의 equals 메소드 오버라이딩
			//		public boolean equals(Object anObject) {
			//	        if (this == anObject) {
			//	            return true;
			//	        }
			//	        if (anObject instanceof String) {
			//	            String aString = (String)anObject;
			//	            if (coder() == aString.coder()) {
			//	                return isLatin1() ? StringLatin1.equals(value, aString.value)
			//	                                  : StringUTF16.equals(value, aString.value);
			//	            }
			//	        }
			//	        return false;
			//	    }
	}
}
