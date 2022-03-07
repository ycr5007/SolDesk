package classtest;

public class Student2 {
	/*
		속성(특성) § 멤버 변수(Property)로, 필수는 아님
			ex ) 학번, 이름, 주소, 핸드폰 ...
		기능(동작) § 멤버 메소드로, 필수는 아님
			ex ) 핸드폰 번호변경, 주소변경 ...
	*/
	
	/*
		생성자 (Constructor) : 초기화 담당, 래퍼런스를 생성할 때 객체에 필요한 사전작업을 실행해준다.
			- 생성자는 여러 개 만들 수 있다. 단, 매개변수가 모두 달라야한다.(Type, 개수, 순서)
			- default 생성자 / 인자(매개변수)를 받는 생성자
			- overloading : 하나의 클래스에 동일한 이름으로 여러개의 메소드를 생성하는 것 (단, 매개변수가 모두 달라야 한다.)
			§ 매개변수 (arguments) 함수를 실행하는데 있어서 필요한 변수들을 메소드 실행전에 받아옴
		접근제한자 클래스명() { } ※ 반환값이 없음
		
		Overloading 의 이유
			- 객체마다 차이가 있을 수 있기 때문에
			
		JAVA 내부 클래스 확인 방법
			Ctrl + 클래스명 클릭 : Open Declaration
	*/
	
	int studentId;
	String studentName;
	String Address;
	String Tel;
	
	// default 생성자
	public Student2() {
		System.out.println("Student2 클래스의 Default 생성자 입니다.");
	}
	
	// 인자를 받는 생성자
	public Student2(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		System.out.println("Student2 클래스의 2개의 args가 있는 생성자 입니다.");
		System.out.println("Student2 클래스 : " + this.studentId + " / " + this.studentName);
	} 
	/*
		this : 객체 자기자신을 의미한다. ex) this.studentId >> Student2 클래스의 studentId 에 접근
			- 매개변수와 멤버변수가 일치할경우, 구분지어주는 역할을 함
	*/
	
	// 2개지만 매개변수 입력 순서가 달라 오버로딩 됨
	public Student2(String studentName, int studentId) {
		this.studentId = studentId;
		this.studentName = studentName;
		System.out.println("Student2 클래스의 2개의 args가 있는 생성자 입니다.");
		System.out.println("Student2 클래스 : " + this.studentId + " / " + this.studentName);
	} 
	
	public Student2(int studentId, String studentName, String Address) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.Address = Address;
		System.out.println("Student2 클래스의 3개의 args가 있는 생성자 입니다.");
		System.out.println("Student2 클래스 : " + this.studentId + " / " + this.studentName);
		System.out.println("Student2 클래스 : " + this.Address);
	} 
	
	public Student2(int studentId, String studentName, String Address, String Tel) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.Address = Address;
		this.Tel = Tel;
		System.out.println("Student2 클래스의 4개의 args가 있는 생성자 입니다.");
		System.out.println("Student2 클래스 : " + this.studentId + " / " + this.studentName);
		System.out.println("Student2 클래스 : " + this.Address + " / " + this.Tel);
	} 
	
	public static void main(String[] args) {
		// 생성자에서 지정한 매개변수 순서대로 생성해야한다.
		// public Student2(int studentId, String studentName)
		Student2 student_default = new Student2();
		System.out.println("sutdent_default > 학번 : " + student_default.studentId + " / 이름 : " + student_default.studentName);
		System.out.println("sutdent_default > 주소 : " + student_default.Address + " / 전화번호 : " + student_default.Tel);
		System.out.println();
		Student2 student_args2 = new Student2(20220307, "홍길동");
		System.out.println("student_args2 > 학번 : " + student_args2.studentId + " / 이름 : " + student_args2.studentName);
		System.out.println("sutdent_args2 > 주소 : " + student_args2.Address + " / 전화번호 : " + student_args2.Tel);
		System.out.println();
		Student2 student_args2_reverse = new Student2("고길동", 20200307);
		System.out.println("student_args2_reverse > 학번 : " + student_args2_reverse.studentId + " / 이름 : " + student_args2_reverse.studentName);
		System.out.println("sutdent_args2_reverse > 주소 : " + student_args2_reverse.Address + " / 전화번호 : " + student_args2_reverse.Tel);
		System.out.println();
		Student2 student_args3 = new Student2(20210203, "성춘향", "강남");
		System.out.println("student_args3 > 학번 : " + student_args3.studentId + " / 이름 : " + student_args3.studentName);
		System.out.println("sutdent_args3 > 주소 : " + student_args3.Address + " / 전화번호 : " + student_args3.Tel);
		System.out.println();
		Student2 student_args4 = new Student2(20210905, "이몽룡", "충북", "010-0000-1111");
		System.out.println("student_args4 > 학번 : " + student_args4.studentId + " / 이름 : " + student_args4.studentName);
		System.out.println("sutdent_args4 > 주소 : " + student_args4.Address + " / 전화번호 : " + student_args4.Tel);
		
	}
}
