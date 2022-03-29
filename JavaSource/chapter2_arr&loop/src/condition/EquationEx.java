package condition;

/*
	4x + 5y = 60
	x, y는 10 이하의 자연수  
*/

public class EquationEx {
	public static void main(String[] args) {
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if((4 * x) + (5 * y) == 60) {
					System.out.println("4x + 5y = 60 의 해 : " + x + " / " + y);
				}
			}
		}
	}
}
