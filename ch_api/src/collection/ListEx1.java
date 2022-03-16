package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
	List 인터페이스
		- 순서가 있음
		- 데이터 중복 허용
		- 구현 클래스 : ArrayList, Vector, LinkedList, Stack ...
		
		> 구조는 배열과 동일하나, 추가된 기능으로 사용이 편리하다.

	선언
		List<Object> name = new ArrayList<Object>();
*/

public class ListEx1 {
	public static void main(String[] args) {
		
		// 기본타입 => Wrapper 클래스
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(3);
		list.add(5);
		list.add(7);
		
		System.out.println(list);
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		list.add(3, 11); // 순서가 있기 때문에 특정 Index에 삽입할 수 있다.
		System.out.println(list);
		
		for(Integer i : list) {
			System.out.print(i + " ");
		}
	}
}
