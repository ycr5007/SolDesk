package classtest;

/*
	코딩 켄벤션 : 코딩을 할 때 읽고, 이해하기 쉽도록 정한 규칙
		변수 - 문자로 시작
			- 소문자로 지정
			- 두 단어인경우 두번째 단어부터 대문자로 구분 ( camel case > JAVA ) / ' _ ' 를 통해 구분하는 경우도 있음 ( snake case > Python )
*/

/*
	접근제한자 Type ClassName { }
	
	접근제한자 ( public, private ... )
	객체의 Type ( class, interface, enum ... )
	클래스명 ※ 클래스의 이름은 대문자로 시작
*/

class Student {
// 메인메소드가 없으면, 실행이 불가하다
	
	/*
		속성(특성) § 멤버 변수(Property)로, 필수는 아님
			ex ) 학번, 이름, 주소, 핸드폰 ...
		기능(동작) § 멤버 메소드로, 필수는 아님
			ex ) 핸드폰 번호변경, 주소변경 ...
	*/
	
	// 속성
	int studentId;
	String studentName;
	String Address;
	String Tel;
	
	// 기능
	void changeTel() {
		
	}
	
	void changeAddress() {
		
	}
	
	
/*
	클래스 ( 어떠한 내용들의 묶음을 틀로하여 여러 곳에서 사용이 가능하다 )
	객체 생성 및 실행
	
	Class명 변수명 = new Class명();
*/
	public static void main(String[] args) {
		Student student1 = new Student(); // Heap 메모리에 생성
		
		// 객체 생성 후 초기화 작업 필요
		student1.studentId = 20220307;
		student1.studentName = "홍길동";
		student1.Address = "서울시 OO구";
		student1.Tel = "010-1234-5678";
		
		// 메소드 실행
		student1.changeAddress();
		
		Student student2 = new Student();
		
		student2.studentId = 20220307;
		student2.studentName = "성춘향";
		student2.Address = "광명시 OO동";
		student2.Tel = "010-5678-1234";
		
	}
}
