package api;

// 정적 import 구문
import static java.lang.Math.*;
// Math는 import 문이 필요 없지만, static 예약어를 붙여 강제로 import 한다.
	// class를 뗴어내고 메소드 사용 가능

// 갖고 있는 메소드가 전부 static 일 때 정적 import 구문 사용가능

public class MathEx2 {
	public static void main(String[] args) {
		double val = 90.7552;
		
		System.out.println("반올림 : " + round(val));
		System.out.println("올림 : " + ceil(val));
		System.out.println("내림 : " + round(val));
		System.out.println("랜덤 : " + random());
	}
}
