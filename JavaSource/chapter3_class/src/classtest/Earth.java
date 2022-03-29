package classtest;

import java.util.Scanner;

/*
	static final : 상수 ( 변수명은 모두 대문자로 표현 )
*/

public class Earth {
	static final double EARTH_RADIUS = 6400;
	final static double EARTH_SURFACE_AREA;
	
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반지름 > " + Earth.EARTH_RADIUS + "km");
		System.out.println("지구의 표면적 > " + Earth.EARTH_SURFACE_AREA + "km2");
		sc.close();
	}
}
