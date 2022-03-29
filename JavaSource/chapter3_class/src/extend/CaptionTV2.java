package extend;

/*
		Implicit super constructor TV2() is undefined for default constructor. Must define an explicit constructor
			> 부모클래스에 default 생성자가 아닌, 인자를 요구하는 생성자가 있으며, 자식클래스에 충족시키는 생성자가 없어 에러 발생
			> default 생성자는 상속과정에서 문제없이 실행이 가능하다
			> 생성자에 내용이 있을 경우, 상위 클래스의 생성자(super();) 내용을 충족할 수 있도록 인자를 받아 넘겨줘야할 필요가 있다
			
				public CaptionTV2() {
					super(); >> 부모클래스의 생성자 호출 (default 생성자의 경우, default 생성자 호출)
				}
				
				public CaptionTV2(String color, boolean power, int channel) {
					super(color, power, channel); >> 부모클래스의 인자값을 받는 생성자를 호출
				}
 */

public class CaptionTV2 extends TV2 {
	
	// Caption 기능
	boolean caption;
	
	public CaptionTV2(String color, boolean power, int channel, boolean caption) {
		super(color, power, channel);
	}

	void display(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}
