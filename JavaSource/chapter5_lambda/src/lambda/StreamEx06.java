package lambda;

import java.util.stream.IntStream;

public class StreamEx06 {
	public static void main(String[] args) {
		// 정수 1 ~ 10 숫자를 stream 생성
		IntStream intStream = IntStream.rangeClosed(1, 10);
		
//		intStream.filter(n -> (n % 2) == 0).forEach(System.out::println);
		
		// i 를 2로 나눈 나머지가 0이 아니고, 3으로 나눈 나머지가 0이 아닌 요소 출력
		intStream.filter(n -> n % 2 != 0 && n % 3 != 0).forEach(System.out::println);
		
		// java.lang.IllegalStateException: stream has already been operated upon or closed
			// Stream 두개 열려있는 경우, 발생하는 에러
	}
}
