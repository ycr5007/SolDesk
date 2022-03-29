package op;

import java.util.Scanner;

/*
	화씨온도 > 섭씨온도 변환
	
	화씨온도 입력받은 후 섭씨 온도로 변환하기 (섭씨온도 = 화씨온도 - 32) * 5/9
*/

public class Degrees {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int fahr;
		double celsius;
		
		System.out.print("화씨온도 : ");
		fahr = sc.nextInt();
		// 상수의 자료형 !!
			// 5/9 (int 계산이기 떄문에 몫 (0) 으로 출력)
			// 5/9.0 (double 계산이기 떄문에 (5/9) 로 출력)
		celsius = (fahr - 32) * (5 / 9.0);
		
		System.out.println("섭씨온도 > " + celsius);
		/* 
			서식지정 출력 ( printf ) > 개행이 없기 때문에 따로 실행해야 함
				%f > 실수형 ( 자리수 표현은 %.nf ) 
				%d > 정수형
				%c > 문자형 ( ' ' )
				%s > 문자열 ( " " )
		*/
		System.out.printf("변화된 섭씨 온도 : %.3f\n", celsius);
		System.out.println("계산 끝 !");
		
		sc.close();
	}
}
