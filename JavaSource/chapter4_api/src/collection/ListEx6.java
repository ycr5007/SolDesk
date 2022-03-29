package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEx6 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("apple");
		list.add("strawberry");
		list.add("banana");
		list.add("kiwi");
		list.add("grape");
		
		
		// List 를 배열로
		Object[] list2Arr = list.toArray();
//		String[] strArr = (String[]) list.toArray();
		
		for(Object obj : list2Arr) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		// 배열을 List로
		String[] fruitsArr = {"apple", "melon", "grape", "banana", "plum", "peach"};
		List<String> arr2List = Arrays.asList(fruitsArr);
//		ArrayList<String> arr2List = (ArrayList<String>) Arrays.asList(fruitsArr);
		
		System.out.println(arr2List);
		try {
			arr2List.add("strawberry"); // java.lang.UnsupportedOperationException	( Runtime Exception )
										// Array.asList 로 생성한 리스트는 (고정)되어 있어 원소를 제거 할 수 없다고 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(arr2List);
		
		// 배열로부터 생성하는 List 를 수정가능하도록 생성하는 방법
		List<String> listException = new ArrayList<String>(Arrays.asList(fruitsArr));
		listException.add("strawberry");
		System.out.println(listException);
	}
}
