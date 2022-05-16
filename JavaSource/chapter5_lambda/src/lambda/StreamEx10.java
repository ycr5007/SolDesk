package lambda;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamEx10 {
	public static void main(String[] args) {
		IntStream stream = Arrays.stream(new int[] {1,2,3,4,5});

		// 2의 배수
		
		// 2의 배수 개수
//		long cnt = stream.filter(n -> n % 2 == 0)
//						.count();
		// 2의 배수 합
//		int sum = stream.filter(n -> n % 2 == 0)
//						.sum();
		// 2의 배수 평균
//		OptionalDouble avg = stream.filter(n -> n % 2 == 0)
//						.average();
		// 2의 배수 최대값 / 최소값
		OptionalInt max = stream.filter(n -> n % 2 == 0)
				.max();
//		OptionalInt min = stream.filter(n -> n % 2 == 0)
//				.min();
		// 2의 배수 첫번째 값
//		OptionalInt find = stream.filter(n -> n % 2 == 0)
//				.findFirst();
		
		System.out.println(max);
	}
}
