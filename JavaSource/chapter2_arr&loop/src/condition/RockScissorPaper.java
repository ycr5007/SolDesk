package condition;

import java.util.Scanner;

/*
	가위바위보
		가위 = 1, 바위 = 2, 보 = 3
		
	컴퓨터가 무작위로 1 ~ 3 까지의 숫자 중에서 하나를 가지고 있도록 한다.
	누가 이겼는지 결과 출력
*/

public class RockScissorPaper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int com = (int)(Math.random() * 3) + 1;
		
		System.out.print("가위 = 1, 바위 = 2, 보 = 3 : ");
		int user = sc.nextInt();
		
		System.out.println("user : " + user + " / com : " + com);
		
//		if(user == com) {
//			System.out.println("draw");
//		}else {
//			if(user - com == 2 || com - user == 2) {
//				if(user > com) {
//					System.out.println("lose");
//				}else {
//					System.out.println("win");
//				}
//			}else {
//				if(user > com) {
//					System.out.println("win");
//				}else {
//					System.out.println("lose");
//				}
//			}
//		}
		
		switch(user - com) {
			case -1: case 2 :
				System.out.println("lose");
				break;
			case -2: case 1 :
				System.out.println("win");
				break;
			default :
				System.out.println("draw");
		}
		sc.close();
	}
}
