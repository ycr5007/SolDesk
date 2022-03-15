package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {
	public static void main(String[] args) {
		
		// 1 차원 배열의 정렬 -> 오름차순
		int arr1[] = {37, 21, 56, 99, 88, 56, 62, 15, 39, 78};
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		// 1 차원 배열의 정렬 -> 내림차순
//		int arr2[] = {37, 21, 56, 99, 88, 56, 62, 15, 39, 78};
		Integer arr2[] = {37, 21, 56, 99, 88, 56, 62, 15, 39, 78};
		
		// The method sort(int[]) in the type Arrays is not applicable for the arguments (int[], Comparator.reverseOrder())
		// T, E, K, V : 객체를 의미
		Arrays.sort(arr2, Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr2));
		
		// 문자열 배열의 정렬 ( a ~ z )
		String arr3[] = {"good", "height", "very", "apple", "zero", "zoo"};
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
		
		// 문자열 배열의 정렬 ( z ~ a )
		String arr4[] = {"good", "height", "very", "apple", "zero", "zoo"};
		Arrays.sort(arr4, Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr4));
		
		// 한글 배열의 정렬 ( ㄱ ~ ㅎ )
		String arr5[] = {"대한민국", "우리나라", "서울", "대구", "부산", "나주"};
		Arrays.sort(arr5);
		System.out.println(Arrays.toString(arr5));

		// 한글 배열의 정렬 ( ㅎ ~ ㄱ )
		String arr6[] = {"대한민국", "우리나라", "서울", "대구", "부산", "나주"};
		Arrays.sort(arr6, Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr6));
	}
}
