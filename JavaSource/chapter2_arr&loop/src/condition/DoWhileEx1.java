package condition;

import java.util.Scanner;

/*
	do ~ while
		처음 반복문을 실행할 때, 조건에 맞지 않더라도 한번은 실행하는 반복문 (for, while 은 조건에 맞지 않을경우, 실행 안됨)
	
	do{
		반복할 문장
	}while(조건식); > 조건이 만족하는지를 마지막에 검사하기 때문에 한 번은 수행 됨
*/

/*
	1 ~ 100 사이의 임의의 숫자 맞추기  
*/

public class DoWhileEx1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rand = (int)(Math.random() * 100) + 1;
		int input = 0;
		
		do {
			System.out.print("숫자를 입력해주세요 (1 ~ 100) : ");
			input = sc.nextInt();
			
			if(rand < input) {
				System.out.println("DOWN !!");
			}else if(rand == input) {
				System.out.println("정답 !!");
			}else {
				System.out.println("UP !!");
			}
			
		}while(input != rand);
		System.out.println("종료합니다 !!");
		sc.close();
	}
}
