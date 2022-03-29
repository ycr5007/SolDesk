package interfacetest;

public class RemoteEx {
	public static void main(String[] args) {
		RemoteControl rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		System.out.println();
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
		// 익명 구현 객체
			// interface 객체를 생성 ( 추상메소드를 불러와 오버라이딩 )
			// 1회성 객체 ( 클래스(src)를 만들지 않고, 객체를 직접 구현하여 사용 )
//		RemoteControl rc1 = new RemoteControl(); // Cannot instantiate the type RemoteControl
		RemoteControl rc1 = new RemoteControl() {
			
			int volume;
			
			@Override
			public void turnOn() {
				System.out.println("축음기를 켭니다");
			}
			
			@Override
			public void turnOff() {
				System.out.println("축음기를 끕니다.");
			}
			
			@Override
			public void setVolume(int volume) {
				if(volume > RemoteControl.MAX_VOLUME) {
					this.volume = RemoteControl.MAX_VOLUME;
				}else if(volume < RemoteControl.MIN_VOLUME) {
					this.volume = RemoteControl.MIN_VOLUME;
				}else {
					this.volume = volume;
				}
				System.out.println("현재 축음기 볼륨 : " + this.volume);
			}
		};
		System.out.println();
		rc1.turnOn();
		rc1.turnOff();
		rc1.setVolume(100);
				
	}
}
