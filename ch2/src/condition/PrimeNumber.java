package condition;

/*
	1 ~ 100 까지 숫자 중에서 소수 구하기
	1 과 자기 자신으로만 나누어지는 수 
*/

public class PrimeNumber {
	public static void main(String[] args) {
		for(int i = 2; i <= 100; i++) {
			boolean flag = true; 
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					flag = false;
				}
			}
			if(flag) {
				System.out.print("i : " + i + "\t");
			}
		}
	}
}
