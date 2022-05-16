package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamEx05 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("바질", "타임", "바나나", "강황", "바둑", "생강");
		
		// '바'로 시작하는 단어만 출력
		for(String s : list) {
			if(s.startsWith("바")) {
				System.out.print(s + "\t");
			}
		}
		System.out.println();
		// Stream - Filter 이용
		list.stream().filter(s -> s.startsWith("바")).forEach(s -> System.out.print(s + "\t"));
		list.stream().filter(s -> s.startsWith("바")).forEach(System.out::print);
		
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("송해송송해", 50));
		studentList.add(new Student("해송해송", 30));
		studentList.add(new Student("해송해", 66));
		studentList.add(new Student("송해", 80));
		studentList.add(new Student("송해송해", 93));
		studentList.add(new Student("송송해", 15));
		
//		studentList.stream().filter(stu -> stu.getPoint() >= 50).forEach(s -> System.out.println(s.getName() + "의 점수는 >> " + s.getPoint()));
//		studentList.stream().map(st -> st.getPoint()).filter(p -> p >= 50).forEach(p -> System.out.println(p));
		studentList.stream().map(stu -> stu.getPoint()).filter(s -> s >= 80).forEach(System.out::print);
	}
}
