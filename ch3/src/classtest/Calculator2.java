package classtest;

/*
	클래스 내부에서 멤버변수, 메소드를 사용할 떄는 이름만 사용해서 작성
*/

public class Calculator2 {
	int plus(int x, int y) {
		return x + y;
	}
	
	double avg(int x, int y) {
		return (double)(plus(x, y)) / 2;
	}
	
	void execute() {
		double result = avg(7,10);
		println("실행결과 = " + result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		Calculator2 calc = new Calculator2();
		calc.execute();
	}
}
