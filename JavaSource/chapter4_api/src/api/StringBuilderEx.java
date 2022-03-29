package api;

/*
	StringBulder ( 싱글 스레드 )
			문자열을 표현하기 위한 클래스
			
	StringBuffer ( 멀티 스레드 )
			문자열을 표현하기 위한 클래스
			
	>> String( imutable ) 클래스와 다른점, mutable ( 변경 가능 ) => ※ append, insert, delete 기능 제공
		
		return type				methods
		StringBuilder			append(AnyType); > 추가
								delete(startNum, endNum); > startNum 부터 endNum 까지 문자열 삭제
								insert(insertNum, "String"); > insertNum 에 문자열 삽입
								reverse(); > 문자열을 반대로 뒤집는다.
*/

public class StringBuilderEx {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("Hello Java");
		builder.append("안녕하세요");
		System.out.println(builder);
		
//		builder = "x"; => append 통해서 추가 가능
		System.out.println(builder.delete(0, 2));
		builder.insert(2, "T");
		System.out.println(builder);
		
		StringBuilder builder1 = new StringBuilder("Hello");
		StringBuilder builder2 = new StringBuilder("Hello");
		
		// equals 오버라이딩 안되어 있어, 주소비교
		System.out.println(builder1.equals(builder2)); // false
		
		String str1 = new String(builder1); // StringBuilder 를 String 객체에 대입 가능
		String str2 = new String(builder2); 
		System.out.println(str1.equals(str2)); // true
		
		StringBuilder reverse = new StringBuilder("avaJ olleH");
		reverse.reverse();
		System.out.println(reverse);
	}
}
