package collection;

import java.util.ArrayList;
import java.util.List;

public class ListEx2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("java");
		list.add("jsp");
		list.add("html");
		list.add("css");
		list.add("mybatis");
		
		// toString 으로 출력하는 방식
		System.out.println(list);
		
		System.out.println();
		
		// for 문을 이용하여 출력
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
			// size() : List 의 배열 크기(길이)
			// get(index) : index 에 있는 데이터 반환
		}
		
		System.out.println();
		
		// 향상된 for 문을 이용하여 출력
		for(String str : list) {
			System.out.println(str);
		}
		
	}
}
