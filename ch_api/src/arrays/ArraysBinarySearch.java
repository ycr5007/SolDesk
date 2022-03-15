package arrays;

import java.util.Arrays;

//검색

/*
			선형(순차)검색 - 정렬되어 있는 경우
			1	2	8	9	11	19	29
			
			9를 검색하는경우
				1. 9 > 1	1^	2	8	9	11	19	29
				1. 9 > 2	1	2^	8	9	11	19	29
				1. 9 > 8	1	2	8^	9	11	19	29
				1. 9 = 9	1	2	8	9^	11	19	29
			검색 성공

*/
/*
	BinarySearch : 이진 검색
		- 탐색 범위의 중간부터 시작하여, 비교를 해 절반의 숫자 제거
			매 단계마다 남은 범위의 가운데 수를 말하고 대답에 따라 절반 제거 반복
		- 데이터는 반드시 정렬된 상태여야 한다.
		
		§ 2개로 나누어, 앞과 뒤를 나누어 검색 ( 현존하는 검색 방법 중 가장 빠름 )
		
		ex) 11 검색
		①		1		2		8		9		11		19		29
										기준
		②		1		2		8		9		11		19		29
														기준
		③		1		2		8		9		11		19		29
												검색)
*/

public class ArraysBinarySearch {
	public static void main(String[] args) {
		int arr[] = {11, 13, 25, 27, 36, 45, 65};
		
		// 이진 검색 ( Arrays.binarySearch(배열, 값); )
		System.out.println(Arrays.binarySearch(arr, 40));
		System.out.println(Arrays.binarySearch(arr, 36));
	}
}
