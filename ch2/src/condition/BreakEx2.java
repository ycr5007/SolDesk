package condition;

/*
	while(조건식1){
		while(조건식2){
			break; > 중첩되어있는 경우 break 문이 위치한 반복문을 탈출한다. (조건식2)
		}
	}
*/

/*
	주사위를 던져 6이 나오면 반복문 종료
*/
public class BreakEx2 {
	public static void main(String[] args) {
		int dice = 0;
		while(true) {
			dice = (int)(Math.random() * 6) + 1;
			if(dice == 6) {
				break;
			}
			System.out.println("주사위 눈 : " + dice);
		}
		System.out.println("주사위가 6이 나왔습니다. 프로그램을 종료합니다.");
	}
}
