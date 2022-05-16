package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx04 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "def", "apple", "melon", "text");
		List<String> upperList1 = new ArrayList<String>();
		
		// 대문자로 변경 후 출력
		// ──────────────────────────────────── 기 존 ────────────────────────────────────
//		for(String st : list) {
//			upperList1.add(st.toUpperCase());
//		}
//		
		// ──────────────────────────────────── 람 다 ────────────────────────────────────
//		list.stream().map(String::toUpperCase)
//			.forEach(str -> upperList1.add(str));
		
		
		// ──────────────────────────────────── 컬렉트 ────────────────────────────────────
		List<String> upperList2 = list.stream().map(String::toUpperCase)
		.collect(Collectors.toList());
		
		
		System.out.println(upperList2);
	}
}
