package access;

public class Car {
	private int speed;
	private boolean stop;

	// 생성자를 private 로 설정하여, 외부에서 접근이 불가하여 일반적으로는 사용하지 않는다.
	private Car(int speed, boolean stop) {
		this.speed = speed;
		this.stop = stop;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
}
