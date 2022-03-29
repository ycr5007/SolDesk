package condition;

/*
	주사위 프로그램
*/

public class IfEx6 {
	public static void main(String[] args) {
		// Math : 수학과 관련된 Class
			// Math.random() : 0 ~ 1 사이 무작위 실수가 출력되도록 처리 (난수발생)
		
		int dice = (int)(Math.random() * 6) + 1;
		
		if(dice == 1) {
			System.out.println("주사위 1번");
		} else if(dice == 2) {
			System.out.println("주사위 2번");
		} else if(dice == 3) {
			System.out.println("주사위 3번");
		} else if(dice == 4) {
			System.out.println("주사위 4번");
		} else if(dice == 5) {
			System.out.println("주사위 5번");
		} else {
			System.out.println("주사위 6번");
		}
	}
}
