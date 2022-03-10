package exam;

import java.util.Scanner;

public class AccountEx1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account1 account = new Account1();

		System.out.print("계좌를 신설하셨습니다. 최고입금액을 입력하세요 > ");
		account.setBalance(Integer.parseInt(sc.nextLine()));
		System.out.print("입금액을 입력하세요 > ");
		account.depositBalance(Integer.parseInt(sc.nextLine()));
		System.out.print("출금액을 입력하세요 > ");
		account.withdrawBalance(Integer.parseInt(sc.nextLine()));
		
		sc.close();
	}
}
