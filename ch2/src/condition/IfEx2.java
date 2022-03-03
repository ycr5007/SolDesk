package condition;

/*
	if(조건식) {
		조건 참 수행문;
	}else {
		조건 거짓 수행문;
	}
	
	※ 삼항 연산자로 했던 작업들은 if~else 구조로 변경 가능
*/

public class IfEx2 {
	public static void main(String[] args) {
		int score = 90;
		
		// score >= 90 : 메세지 출력
		// score < 90 : 메세지 출력
		
		if(score >= 90) {
			System.out.println("점수는 90 점 이상입니다.");
			System.out.println("등급은 A 입니다.");
		}else {
			System.out.println("점수는 90 점 미만입니다.");
			System.out.println("등급은 B 입니다.");
		}
	}
}
