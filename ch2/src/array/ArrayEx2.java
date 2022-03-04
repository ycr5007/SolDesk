package array;

public class ArrayEx2 {
	public static void main(String[] args) {
		
		// way 1 - 배열 선언 , 생성, 초기화
		int arr1[] = new int[3];
		
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		
		// way 2 - 배열 선언 , 생성 , 초기화
		int arr2[] = new int[] {10, 20, 30};
		
		// way 3 - 배열 선언 , 생성 , 초기화
		int arr3[] = {10, 20, 30};
		
		// way 4
		int arr4[];
		arr4 = new int[] {10, 20, 30};
		
		// 반복문을 활용한 배열 접근
		for(int i = 0; i < 3; i++) {
			System.out.println(arr2[i]);
		}
		
	}
}
