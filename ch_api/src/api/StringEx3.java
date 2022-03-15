package api;

import java.util.Arrays;

/*
	String Methods
			String(imutable) 자체는 불변 객체, 떄문에 Method 들은 새로운 값을 반환한다.
			String 의 경우, 불변객체이기 때문에 추가 및 대입의 관계에서 생성 및 객체의 파괴가 계속 반복이 진행되어 효율성이 많이 떨어진다.
				StringBuffer 또는 StringBuilder 를 사용하는 것이 효율 ↑
			
		return type			method
		char				String.charAt(n); > n(0 ~ n) 번째 문자열을 반환
		int					String.length(); > 문자열의 길이 (문자, 공백, 특수문자 모두 포함)를 반환
		int					String.indexOf("String"); > 지정한 문자열의 가장 먼저 온 인덱스 번호를 구하는 메소드 ( 없을 경우 -1 반환 )
												("String", startInt); > 지정한 문자열의 startInt 에서 시작하여 지정한 문자열이 오는 인덱스 번호를 구하는 메소드
		int					String.lastIndexOf("String"); > 지정한 문자열의 가장 나중에 온 인덱스 번호를 구하는 메소드 ( 없을 경우 -1 반환 )
		boolean				String.contains(CharSequence(String)); > CharSequence, 즉 문자열을 갖고있는지 확인하는 메소드
		String				String.substring(startNum); > startNum 부터 출력, startNum 이전 문자열은 자름
												(startNum, endNum); > startNum 부터 endNum 까지 문자열을 자름
		String				String.replace("targetString", "replaceString"); > String 의 모든 targetString 을 replaceString 으로 변경
												('targetChar', 'replaceChar'); > String 의 모든 targetChar 을 replaceChar 으로 변경
		String				String.replaceFirst("targetString", "replaceString"); > String 의 가장 먼저 온 targetString 을 replaceString 으로 변경
		String				String.concat("String"); > 문자열 연결
		boolean				String.equalsIgnoreCase("String"); > 대소문자를 구분하지 않고, 문자열을 비교한다.
		boolean				String.startsWith("String"); > 문자열이 매개변수 String 으로 시작하는지 확인
		boolean				String.endsWith("String"); > 문자열이 매개변수 String 으로 끝나는지 확인
		String				String.toUpperCase(); > 알파벳을 모두 대문자로 변경
		String				String.toLowerCase(); > 알파벳을 모두 소문자로 변경
		String[]			String.split("구분자"); > 구분자를 기준으로 문자열을 잘라서, 배열로 반환
		String				String.trim(); > 공백제거 (문자 사이 중간 공백은 제거 X)
static	String				String.valueOf(Any Type); > Type을 String 으로 변경하여 출력
								>> 문자열을 자료형으로 변경, TypeObject(Integer, Boolean ...).parseType(Int, Boolean ...)("String");
		
		
	regex ( 정규표현식 )
*/

public class StringEx3 {
	public static void main(String[] args) {
		String str1 = "자바 프로그래밍";
		System.out.println(str1.charAt(3));
		// String.charAt(n); > n(0 ~ n) 번째 문자열을 반환
		
		String str2 = "Hello Java";
		
		// str2 문자열을 char배열로 생성하고 출력하기
		char[] chArr = new char[str2.length()];
		for(int i = 0; i < chArr.length; i++) {
			chArr[i] = str2.charAt(i);
			System.out.print(chArr[i] + " ");
		}
		System.out.println();
		// String.length(); > 문자열의 길이 (문자, 공백, 특수문자 모두 포함)를 반환
		
		// 문자열에 '프' 문자가 들어있는지 확인하는 프로그램 작성
		// 문자가 들어있음, 없음
		boolean flag = false;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) == '프') {
				flag = true;
			}
		}
		System.out.println(flag ? "문자가 들어있음" : "없음");
		
		System.out.println(str1.indexOf("그")); 
		// String.indexOf("String"); > 지정한 문자열의 인덱스 번호를 구하는 메소드 (앞에서부터 검색)
		System.out.println(str1.lastIndexOf("그"));
		
		String str3 = new String("HelloHelloHello World");
		System.out.println(str3.indexOf("Hello"));
		System.out.println(str3.lastIndexOf("Hello"));
		System.out.println(str3.indexOf("o", str3.lastIndexOf("Hello")));
		
		System.out.println(str1.contains("프"));
		
		String ssn = "880515-12220146";
		System.out.println(ssn.substring(7));
		System.out.println(ssn.substring(0, 6));
		
		System.out.println(str2.replace("Java", "자바"));
		System.out.println(str2);
		// String 자체는 불변, 떄문에 Method 들은 새로운 값을 반환한다.
		System.out.println(str2.replace('J', 'j'));
		
		// String 의 경우, 불변객체이기 때문에 추가 및 대입의 관계에서 생성 및 객체의 파괴가 계속 반복이 진행되어 효율성이 많이 떨어진다.
			// StringBuffer 또는 StringBuilder 를 사용하는 것이 효율 ↑
		String str4 = "Hello";
		str4 += "안녕하세요";
		str4 += "감사해요";
		str4 += "잘있어요";
		str4 += "다시만나요";
		
		System.out.println(str4);
		
		System.out.println(str2.replaceFirst("Java", "자바"));
		
		String s1 = "hello ";
		String s2 = s1.concat("world");
		System.out.println(s2);
		
		String str5 = "Hello";
		String str6 = "hello";
		
		System.out.println(str5.equals(str6)); // String 은 대소문자를 구분한다.
		System.out.println(str5.equalsIgnoreCase(str6)); // 대소문자랑 상관없이 비교한다.
		
		String s = "java.lang.Object";
		
		System.out.println(s.startsWith("java"));
		System.out.println(s.endsWith("java"));
		
		String sup = s.toUpperCase();
		System.out.println(sup);
		
		String slo = sup.toLowerCase();
		System.out.println(slo);
		
		String animals1 = "dog,cat,bear";
		String[] strArr1 = animals1.split(",");
		System.out.println(Arrays.toString(strArr1));

		String animals2 = "dog cat bear";
		String[] strArr2 = animals2.split(" ");
		System.out.println(Arrays.toString(strArr2));
		
		String s3 = "                   Hello World                    ";
		String s4 = "Hello World";
		System.out.println(s3);
		System.out.println(s3.trim()); // 공백제거
		System.out.println(s3.equals(s4)); // 공백도 하나의 문자로 취급하기 때문에, false
		System.out.println(s3.trim().equals(s4)); // 공백을 제거하여, true
		
		// valueOf
		System.out.println(String.valueOf(false));
		System.out.println(String.valueOf(false).getClass());
		System.out.println(String.valueOf('a'));
		System.out.println(String.valueOf('a').getClass());
		System.out.println(String.valueOf(10f));
		System.out.println(String.valueOf(10f).getClass());
		
		boolean changeBoolean = Boolean.parseBoolean("false");
		
		System.out.println(changeBoolean?"논리true":"논리false");
		System.out.println(Float.parseFloat("10.0") + 1);
		
	}
}
