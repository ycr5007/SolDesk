package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachEx1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
		for(String s : list) {
			System.out.print(s + "\t");
		}
		System.out.println();
		
		// 자바 8 버전 이후
		list.forEach(i -> System.out.print(i + "\t"));
		System.out.println();
		
		List<String> items = Arrays.asList("사과", "포도", "자두", "망고", "체리");
		items.forEach(item -> System.out.print(item + "\t"));
		
		System.out.println();
		
		Map<String, Integer> items2 = new HashMap<String, Integer>();
		items2.put("A", 10);
		items2.put("B", 20);
		items2.put("C", 30);
		items2.put("D", 40);
		items2.put("E", 50);
		
		items2.forEach((k, v) -> {
			System.out.println("Item Key : " + k + " / Count : " + v);
			if("E".equals(k)) {
				System.out.println("Hello EE");
			}
		});
	}
}
