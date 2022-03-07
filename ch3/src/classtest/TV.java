package classtest;

/*
	클래스 : 객체의 속성과 기능을 코드로 구현한 것
*/

public class TV {
	String color;
	boolean power;
	int channel;
	
	/*
		생성자를 명시하지 않으면 !! Compiler 가 자동으로 default 생성자를 만들어준다.
	*/
	
	void power() {
		power = !power;
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
	public static void main(String[] args) {
		TV tv = new TV();
		
		tv.color = "black";
		tv.channel = 3;
		tv.power = false;
		
		tv.power();
		
		System.out.println("전원 : " + tv.power + " 현재 채널 : " + tv.channel);
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		System.out.println("전원 : " + tv.power + " 현재 채널 : " + tv.channel);
	}
}
	