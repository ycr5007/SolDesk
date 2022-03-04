package array;

/*
	향상된 for : 배열, 리스트 사용
	for(Type 변수명 : 배열(or 리스트)명){
		수행문;
	}
	
		> (배열명)에서 차례로 하나씩 가져와서 (변수)에 내용을 담는다
*/

public class ArrayEx4 {
	public static void main(String[] args) {
		char chArr[] = {'a', 'b', 'c', 'd', 'e'};
		
		for (int i = 0; i < chArr.length; i++) {
			System.out.print(chArr[i]);
		}
		System.out.println();
		
		System.out.println(chArr); // 출력 : abcde
			// char 배열은 예외로 주소가 안나오고 문자 자체가 출력된다. (println 에서 문자 배열이 갖고 있는 값들을 출력하도록 Overriding 되어있음)
		
		// 변형 for 문 - 배열, 리스트 출력에 훨씬 편리하다.
		for(char ch : chArr) {
			System.out.print(ch);
		}
		System.out.println();
		
		String str[] = {"a", "b", "c", "d", "e"};
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
		System.out.println();
		
		System.out.println(str); // 출력 : [Ljava.lang.String;@7d6f77cc
		
		for(String st : str) {
			System.out.print(st);
		}
	}
}
