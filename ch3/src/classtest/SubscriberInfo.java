package classtest;

public class SubscriberInfo {
	// Property : name, id(문자, 숫자 8자리), password(문자, 숫자, 특수문자 15자리), tel(010-1234-1234), address
	// function : changePassword, changeTel, changeAddress
	
	String name;
	String id;
	String password;
	String tel;
	String address;

	public SubscriberInfo() {	}
	
	public SubscriberInfo(String name, String id, String password, String tel, String address) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.address = address;
	}
	
	// 새로운 비밀번호를 입력받아 기존 비밀번호를 변경
	void changePassword(String password) {
		this.password = password;
		System.out.println("비밀번호 변경이 완료되었습니다.");
	}
	
	// 새로운 전화번호를 입력받아 기존 전화번호를 변경
	void changeTel(String tel) {
		this.tel = tel;
		System.out.println("전화번호 변경이 완료되었습니다.");
	}

	// 새로운 주소를 입력받아 기존 주소를 변경
	void changeAddress(String address) {
		this.address = address;
		System.out.println("주소 변경이 완료되었습니다.");
	}
	
	// 반복되는 가입자 정보 출력 메소드
	static void objectprint(SubscriberInfo info) {
		System.out.println("아이디 : " + info.id);
		System.out.println("이름 : " + info.name);
		System.out.println("비밀번호 : " + info.password);
		System.out.println("전화번호 : " + info.tel);
		System.out.println("주소 : " + info.address);
	}
	
	@Override
	public String toString() {
		return name + " / " + id + " / " + password + " / " + tel + " / " + address;
	}
	
	public static void main(String[] args) {
		SubscriberInfo info1 = new SubscriberInfo("이것은 이름", "이것은 아이디", "이것은 비밀번호", "이것은 전화번호", "이것은 주소");
		SubscriberInfo info2 = new SubscriberInfo("그것은 이름", "그것은 아이디", "그것은 비밀번호", "그것은 전화번호", "그것은 주소");
		SubscriberInfo info3 = new SubscriberInfo("저것은 이름", "저것은 아이디", "저것은 비밀번호", "저것은 전화번호", "저것은 주소");
		
		info1.changeAddress("이것은 바뀐 주소");
		info2.changePassword("그것은 바뀐 비밀번호");
		info3.changeTel("저것은 바뀐 전화번호");
		
		System.out.println();
		System.out.println(info1);
		objectprint(info1);
		System.out.println();
		System.out.println(info2);
		objectprint(info2);
		System.out.println();
		System.out.println(info3);
		objectprint(info3);
	}
}
