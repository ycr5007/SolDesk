package basic;

/*
	실수 
		> 부동소수점 방식 ( 가수부분 / 지수부분 )
			> M : 가수(Mantissa)
			> B : 기수(Base)
			> E : 지수(Exponent)
*/

/*
	실수형
	float : 4byte > 부호비트 1bit, 지수부 8bit, 가수부 23bit > +-(1.40129846432481707e-45 ~ 3.40282346638528860e+38)
*/

public class FloatVariable {
	public static void main(String[] args) {
		float f1 = 90.17F; //Type mismatch: cannot convert from double to float ( 식별자 추가 필요 )
		System.out.println("f1 : " + f1);
	}
}
