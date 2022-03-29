package classtest;

public class Triangle {
	// Property : bottom, height
	// Function : area
	
	int bottom;
	int height;

	public Triangle(int bottom, int height) {
		this.bottom = bottom;
		this.height = height;
	}
	
	double getArea() {
		return (double)(bottom * height) / 2;
	}
	
	public static void main(String[] args) {
		Triangle triangle = new Triangle(15, 5);
		System.out.println("삼각형의 넓이 : " + triangle.getArea());
	}
}
