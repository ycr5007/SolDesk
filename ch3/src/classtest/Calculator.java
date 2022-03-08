package classtest;

public class Calculator {
	
	/*
		overloading : 메소드 이름은 같지만, 매개변수가 다르기 때문에 존재가능하다.
			> 매개변수의 타입, 개수, 순서가 달라야 한다.
	*/
	
	// 정사각형
	double areaRectangle(double width) {
		return width * width;
	}
	
	// 직사각형
	double areaRectangle(double width, double height) {
		return width * height;
	}
	
	
}
