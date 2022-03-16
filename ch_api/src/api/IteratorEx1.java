package api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
	Iterator ( Map , Set , List ... 등의 구조에 대해 표준화 )
		- 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스
		
		- hasNext() : 읽어올 다음 요소가 있는지 확인
		- next() : 다음 요소 읽어오기
		- remove() : next()로 읽어온 요소 삭제
*/

public class IteratorEx1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(2);
		list.add(8);
		list.add(10);
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
