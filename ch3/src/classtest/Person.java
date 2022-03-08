package classtest;

/*
	final
		> 최종적인 값 (고정된 값, 변경불가 값, 상수)
		> 무조건 초기화 필요 (변경이 불가하기 때문에)
		> 직접 초기화, 생성자를 통한 초기화
		> 변수(변경 금지), 메소드(오버라이딩 금지), 클래스(상속 금지)에 모두 사용 가능
*/

public class Person {
	final String NATION = "Korea";
	final String ssn;
	
	String name;

	public Person(String name, String ssn) {
		this.ssn = ssn;
		this.name = name;
	}
	
	public static void main(String[] args) {
		Person person = new Person("1504", "111111-2222222)");
		
		System.out.println("국적 : " + person.NATION);
		System.out.println("이름 : " + person.name);
		System.out.println("주민등록번호 : " + person.ssn);
		
//		person.ssn = "111234"; // The final field Person.ssn cannot be assigned > final 값은 변경이 불가능하다.
	}
	
}
