package classtest;

public class TV2 {
	String color;
	boolean power;
	int channel;
	
	public TV2(String color) {
		this.color = color;
	}

	public TV2(String color, boolean power) {
		this.color = color;
		this.power = power;
	}
	
	public TV2(String color, boolean power, int channel) {
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	
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
		// TV2 tv = new TV2(); // The constructor TV2() is undefined 에러 발생, 매개변수와 생성자가 일치하는 것이 없기 떄문에 정의되지 않은것으로 오류 발생
		TV2 tv = new TV2("white", false, 25);
		
		System.out.println(tv);
	}
}
