package collection;

import java.util.HashSet;
import java.util.Set;

public class SetEx3 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("abc", "Jim", "jimmy11"));
		set.add(new Member("jay", "James", "imjames131"));
		set.add(new Member("edy", "Eddy", "eded009"));
		set.add(new Member("com", "lake", "laycook11"));
		set.add(new Member("com", "lake", "laycook11"));

		System.out.println(set);
	}
}
