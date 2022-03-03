package condition;

/*
	조건문
		주어진 조건에 따라 다른 문장을 선택할 수 있게 해준다.
		
	if(조건식){
		수행문;
	}
	
	※ 블록을 쓰지 않는 경우
	if(조건식)
		수행문; (단, 한줄만 가능하다)
*/

public class IfEx1 {
	public static void main(String[] args) {
		int num = 0;
		
		// num == 0 인 경우, "숫자는 0 입니다" 출력
		// num != 0 인 경우, "숫자는 0 이 아닙니다" 출력
		
		if(num == 0) {
			System.out.println("숫자는 0 입니다");
		}
		
		if(num != 0)
			System.out.println("숫자는 0 이 아닙니다");
	}
}
