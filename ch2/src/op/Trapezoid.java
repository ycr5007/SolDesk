package op;

public class Trapezoid {
	public static void main(String[] args) {

		// 사라디꼴 넓이 구하기
		// 윗변 = 5, 아랫변 = 10, 높이 = 7 변수 선언
		
		int top = 5;
		int bottom = 10;
		int height = 7;
		
		double area = (double)((top + bottom) * height) / 2;
		System.out.println("사다리꼴 넓이 : " + area);
	}
}
