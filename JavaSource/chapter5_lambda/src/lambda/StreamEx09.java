package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
	Stream 최종 연산
	
		forEach()	:
		collect()	: 요소를 그룹화 하거나 분할한 결과를 컬렉션에 담아 반환하는데 사용
			Collectors.toList() :: List 형태로 반환
		count()		: 
		sum()		:
		average()	:
		max()		:
		min()		:
		findFirst()	:
*/

public class StreamEx09 {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("송해송송해", 50));
		studentList.add(new Student("해송해송", 30));
		studentList.add(new Student("해송해", 66));
		studentList.add(new Student("송해", 80));
		studentList.add(new Student("송해송해", 93));
		studentList.add(new Student("송송해", 15));

		// 학생들의 점수만 모아서 새로운 리스트 생성
		// ──────────────────────────────────── 기 존 ────────────────────────────────────
		List<Integer> normalList = new ArrayList<Integer>();
		for(Student element : studentList) {
			normalList.add(element.getPoint());
		}
		
		// ──────────────────────────────────── 람 다 ────────────────────────────────────
		Stream<Student> stream = studentList.stream();
		List<Integer> lambdaPoint = stream.map(Student::getPoint).collect(Collectors.toList());
	}
}
