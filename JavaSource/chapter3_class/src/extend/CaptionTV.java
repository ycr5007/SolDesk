package extend;

/*
	
*/

public class CaptionTV extends TV{
	// Caption 기능
	boolean caption;
	
	void display(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
	
	
	// Class TV 의 변수 및 클래스
//	String color;
//	boolean power;
//	int channel;
//	
//	void power() {
//		power = !power;
//	}
//	
//	void channelUp() {
//		channel++;
//	}
//	
//	void channelDown() {
//		channel--;
//	}
}
