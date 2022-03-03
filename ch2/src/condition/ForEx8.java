package condition;

import java.util.Scanner;

/*

		ㅇ
		ㅇ	ㅇ
		ㅇ	ㅇ	ㅇ
		ㅇ	ㅇ	ㅇ	ㅇ
		ㅇ	ㅇ	ㅇ	ㅇ	ㅇ

*/

public class ForEx8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("개수 : ");
		int user = sc.nextInt();
		
		for(int i = 0; i < user; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}

		System.out.println();
		
		for(int i = 0; i < user; i++) {
			for(int j = 0; j < user; j++) {
				if(j >= ((user - 1) - i)) {
					System.out.print(" * ");
				}else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
