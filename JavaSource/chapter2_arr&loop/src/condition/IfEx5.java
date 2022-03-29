package condition;

/*
	조건이 여러개인 경우
	if(조건식 1) {
		조건식 1 true 수행문;
	}else if(조건식 2) {
		조건식 2 true 수행문;
	}else if(조건식 3) {
		조건식 3 true 수행문;
	}else {
		조건식 1, 2, 3 false 수행문;
	}
*/

public class IfEx5 {
	public static void main(String[] args) {
		// 점수가 90 이상 : A
		// 점수가 80 이상 : B
		// 점수가 70 이상 : C
		// 점수가 70 미만 : D
		
		int score = 80;
		
		if(score >= 90) {
			System.out.println("A");
		}else if(score >= 80) {
			System.out.println("B");
		}else if(score >= 70) {
			System.out.println("C");
		}else {
			System.out.println("D");
		}
	}
}
