package arrays;

import java.util.Arrays;

public class ArraysEqual {
	public static void main(String[] args) {
		int arr1[] = {10, 73, 2, -5, 42};
		int arr2[] = {10, 73, 2, -5, 42};

		// arr1 요소들과 arr2 요소를 비교
		System.out.println(Arrays.equals(arr1, arr2)?"배열요소 같음":"다름");
			// Arrays.equal(arr1, arr2) : 배열 두 개의 값 비교 (순서 및 값)
		
		// 배열요소 출력
		System.out.println(Arrays.toString(arr1));
			// Arrays.toString(arr) > 오버라이딩 된 toString() : 배열의 요소를 출력
		
	}
}
