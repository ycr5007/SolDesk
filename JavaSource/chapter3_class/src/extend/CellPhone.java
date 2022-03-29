package extend;

/*
	상속(Inheritance) >> extends : 확장
		- 기존 클래스를 만들었지만, 기능을 포함하는 다른 클래스를 만들고자 할 때 상속을 통해 기존 클래스의 기능을 불러온다.
		- 모든 클래스는 Object 클래스를 상속받고 있다.(보여지지 않지만, 기본적으로 상속 상태)
	
	문법 : public class className extends SuperClass {	}
		
		CellPhone : 핸드폰의 가장 기본적인 기능을 정리한 Class
			DMBCellPhone : DMB 기능을 추가
		
	부모(상위, super) 클래스 > ex) CellPhone
	자식(하위, sub) 클래스 > ex) DMBCellPhone
	
		상속의 이유
			§ 클래스 재사용 (중복을 줄여준다)
			
		상속의 제한
			§ private 접근제한자를 갖는 필드, 메소드는 상속 불가
			§ 상속은 하나의 클래스만 가능
			
		메소드 오버라이딩 (Method Override)
			- 부모클래스를 상속했을 때, 부모클래스의 메소드 내용을 일부 수정하는 작업 ( { } 블럭 내부만 )
			> 부모가 넘겨주는 메소드를 자식클래스에서 다시 정의하는 것(재정의)
			- 부모클래스와 자식클래스 중 자식클래스의 (메소드 / 변수)가 우선된다. > 부모클래스 지정어 super 를 통해 부모클래스의 변수 또는 메소드에 접근 가능하다.
			
		오버로딩 ? 오버라이딩 ?
			오버로딩 : 하나의 클래스 안에 동일한 이름으로 (생성자,메소드)가 여러개 존재(매개변수의 자료형, 개수, 순서의 차이)
			오버라이딩 : 상속받은 메소드의 재정의
			
		§§§§§§§§§§§§§§
			오버라이딩 되면, 자식클래스의 내용을 우선으로 호출한다.
			오버라이딩 되면, 부모클래스의 내용이 시스템 내에서 보이지 않게 숨겨진다.
*/

public class CellPhone {
	String model;
	String color;
	boolean power;
	
	void powerOnOff() {
		power = !power;
		if(!power) {
			System.out.println("전원을 켭니다.");
		}else {
			System.out.println("전원을 끕니다.");
		}
	}
	
	void bell() {
		System.out.println("벨소리 ♪♪♪");
	}
	
	void sendVoice(String msg) {
		System.out.println("송신 : " + msg);
	}
	
	void receiveVoice(String msg) {
		System.out.println("수신 : " + msg);
	}
	
	void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
}
