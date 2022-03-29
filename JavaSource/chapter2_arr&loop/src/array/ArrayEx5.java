package array;

import java.util.Arrays;

/*
	배열에 있는 모든 인덱스 값을 확인하는 방법 
	
	Arrays 클래스
		import java.util.Arrays;
	
		Arrays.toString(배열명); ( String 반환 ) 
*/

public class ArrayEx5 {
	public static void main(String[] args) {
		int iArr[] = {1, 2, 3, 4, 5};
		String strArr[] = {"abc", "cde", "spring"};
		
		System.out.println(iArr); // [I@7d6f77cc
		System.out.println(Arrays.toString(iArr)); // [1, 2, 3, 4, 5]
		
		System.out.println(strArr); // [Ljava.lang.String;@5aaa6d82
		System.out.println(Arrays.toString(strArr)); // [abc, cde, spring]
	}
}
