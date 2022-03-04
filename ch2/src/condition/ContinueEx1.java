package condition;

/*
	continue : continue 가 실행되면 이후 반복문은 실행하지 않고, 반복문 처음으로 돌아간다.  
*/

public class ContinueEx1 {
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			if(i % 3 == 0) {
				continue;
			} // 0 , 3의 배수는 이후 문장을 실행하지 않고 반복문 처음으로 돌아간다.
			System.out.println("i : " + i);
		}
	}
}
