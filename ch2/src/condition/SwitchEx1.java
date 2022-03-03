package condition;

/*
	switch(변수){
		case 값1 :
			수행문1;
			break;
		case 값2 :
			수행문2;
			break;
		default :
			default 수행문;
			break;
	}
	
	break : 조건문, 반복문을 강제종료 하는 것
		> switch 문에서 break 없을 경우, 모든 case 가 동작하기 때문에 멈춰야 하는 부분을 따로 작성해줘야 한다.
*/

public class SwitchEx1 {
	public static void main(String[] args) {
		
		int dice = (int)(Math.random() * 6) + 1;
		switch(dice) {
			case 1 :
				System.out.println("주사위 1번");
				break;
			case 2 :
				System.out.println("주사위 2번");
				break;
			case 3 :
				System.out.println("주사위 3번");
				break;
			case 4 :
				System.out.println("주사위 4번");
				break;
			case 5 :
				System.out.println("주사위 5번");
				break;
			default :
				System.out.println("주사위 6번");
				break;
		}
	}
}
