package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamEx08 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("사과", "딸기", "바나나", "수박", "참외", "메론", "바나나", "딸기");
		
		list.stream()
			.skip(2)	// 시작위치
			.sorted(Comparator.reverseOrder()) // 정렬
			.limit(3)	// 가져올 값 개수
			.forEach(System.out::println);
	}
}
