package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
	LinkedList
		Vector, ArrayList 의 단점(크기 변경, 비순차적인 데이터의 추가·삭제에 시간이 많이 걸림)을 보완
		
			ArrayList					LinkedList
		===================== 순차적 추가 =====================
			190							286
		===================== 중간에 추가 =====================
			2597						14
		===================== 중간에 삭제 =====================
			1943						124
		===================== 순차적 삭제 =====================
			11							29
*/

public class ListEx7 {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		
		
		list.add("apple");
		list.add("melon");
		list.add("kiwi");
		list.add("plum");
		list.add("berry");
		
		System.out.println(list);
		System.out.println();
		// 두 리스트의 속도 비교
		
		ArrayList<String> al = new ArrayList<String>(200000); // ArrayList 의 속도를 빠르게 하고자 할 때, ArrayList의 사이즈를 키운다.
		LinkedList<String> ll = new LinkedList<String>();

		System.out.println("\tArrayList\t\t\tLinkedList");
		
		System.out.println("===================== 순차적 추가 =====================");
		System.out.println("\t" + add1(al) + "\t\t\t\t" + add1(ll));
		System.out.println("===================== 중간에 추가 =====================");
		System.out.println("\t" + add2(al) + "\t\t\t\t" + add2(ll));
		System.out.println("===================== 중간에 삭제 =====================");
		System.out.println("\t" + remove2(al) + "\t\t\t\t" + remove2(ll));
		System.out.println("===================== 순차적 삭제 =====================");
		System.out.println("\t" + remove1(al) + "\t\t\t\t" + remove1(ll));
		
	}
	
	// 순차적 추가
	public static long add1(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			list.add(i + " ");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	// 중간에 추가
	public static long add2(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			list.add(500, "X");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	// 순차적 삭제
	public static long remove1(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i = list.size() - 1; i >= 0; i--) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	// 역방향 삭제
	public static long remove2(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
}
