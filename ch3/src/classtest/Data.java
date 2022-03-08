package classtest;

public class Data {

	int x;
	
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10;
		
		System.out.println(data.x);

//		change(data.x);
		change(data); // 주소 : Data@7d6f77cc ( main 과 change() 가 갖고 있는 객체가 가리키는 주소가 일치 )
		System.out.println("change() 호출 후");
		System.out.println(data.x);
		System.out.println(data);
	}
	
	static void change(int x) { // 기본형 매개변수
		x = 1000;
		System.out.println("change x = " + x);
	}

	// 인스턴스 data 에서 주소를 받아오기 때문에, 같은 내용을 가리키게 됨
	static void change(Data obj) { // 참조(주소를 통한 접근)형 매개변수
		obj.x = 1000;
		System.out.println("data x = " + obj.x);
		System.out.println(obj); // 주소 : Data@7d6f77cc
	}
	
	/*
		static 예약어가 있는 것만, 직접 접근이 가능하다 (main 도 static 메소드이다)
	*/
	
	void print() { }
}
