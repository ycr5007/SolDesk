package basic;

/*
	실수형
	double(기본 타입) 	: 8byte > 부호비트 1bit, 지수부 11bit, 가수부 52bit > +-(4.94065645841246544e-324d ~ 1.79769313486231570e+308d)
					: double type이 float 타입보다 실수를 더 정밀하게 표현한다. 
*/

// 부동소수점 구하기 문제 ?
//	실수를 입력받아 가수, 기수, 지수로 나누어 출력

public class DoubleVariable {
	public static void main(String[] args) {
		double d1 = 90.17;
		System.out.println("d1 : " + d1);
		
		double d2 = 100.123D; // 기본 타입이기 때문에 식별자는 별도로 필요 없으나, 써줄 수는 있다.
		System.out.println("d2 : " + d2);
	}
}
