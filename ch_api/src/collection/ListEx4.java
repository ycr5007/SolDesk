package collection;

import java.util.List;
import java.util.Vector;

/*
	Vector
		ArrayList와 사용방식이 동일하다
		
	Vector 와 ArrayList
		Vector 가 구버전으로 성능은 ArrayList 쪽이 좋음
		
	장점
		- 데이터를 읽어오고 저장하는데 효율이 좋음
		
	단점
		- 단, 용량을 변경할 때 효율이 떨어짐
	
	> 배열길이의 변경등 개발자가 직접 관여할 일은 없다. 단, 배열과 동작 방식이 같아 효율이 떨어진다.
		=> List 의 크기를 크게 설정하여, 효율성을 올릴 수 있다.
*/

public class ListEx4 {
	public static void main(String[] args) {
		List<String> list = new Vector<String>(40);
		
		list.add("1번");
		list.add("3번");
		list.add("7번");
		list.add("5번");
		
		System.out.println(list);
		
		list.clear();
		
		System.out.println("clear 후 : " + list);
	}
}
