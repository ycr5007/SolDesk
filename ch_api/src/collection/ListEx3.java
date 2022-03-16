package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx3 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		list.add(4);
		list.add(2);
		list.add(0);
		list.add(1);
		list.add(3);

		System.out.println(list);
		// 배열 정렬 > Arrays.sort()
		// 컬렉션 프레임워크 정렬 > Collections.sort();
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println();
		
		// 삭제
		for(int i = list.size() - 1; i >= 0; i--) {
			if(list.contains(list.get(i))) { // 값이 있는지 여부 확인
				list.remove(i);
			}
		}
		System.out.println(list);
	}
}
