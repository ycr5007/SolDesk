package condition;

/*
	break : 반복문을 강제적으로 탈출 
*/

public class BreakEx1 {
	public static void main(String[] args) {
		
		int i = 0;
		int sum = 0;
		
		while(true) { // 무한 반복
			if(sum > 100) {
				break; // 반복문 탈출
			}
			i++;
			sum += i;
		}
		
		System.out.println("i : " + i);
		System.out.println("sum : " + sum);
		
	}
}
