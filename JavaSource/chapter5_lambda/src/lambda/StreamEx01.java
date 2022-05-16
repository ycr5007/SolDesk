package lambda;

import java.util.Arrays;

/*
	Stream : 배열이나 Collection 의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해줌
		코드의 간결성 유지, Mapping, Filtering 과 같은 중간 처리 가능
*/

public class StreamEx01 {
	public static void main(String[] args) {
		String strArr[] = {"사과", "포도", "자두", "망고", "체리"};
		
		// 배열 => Stream 변환
//		Stream<String> stream = Arrays.stream(strArr);
		
//		stream.forEach(s -> System.out.print(s + "\t"));
//		System.out.println();
		
		Arrays.stream(strArr).forEach(s -> System.out.print(s + "\t"));
	}
}
