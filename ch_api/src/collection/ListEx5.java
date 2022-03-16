package collection;

import java.util.ArrayList;
import java.util.List;

public class ListEx5 {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		
		list.add(new Member("abc", "Jim", "jimmy11"));
		list.add(new Member("jay", "James", "imjames131"));
		list.add(new Member("edy", "Eddy", "eded009"));
		list.add(new Member("com", "lake", "laycook11"));
		
		System.out.println(list);
		
		System.out.println();
		
		for(Member member : list) {
			System.out.println(member.getId() + "\t" + member.getName() + "\t" + member.getPassword());
		}
		
		System.out.println();
		
		for(int i = 0; i < list.size(); i++) {
			Member member = list.get(i);
			System.out.println(member);
		}
	}
}
