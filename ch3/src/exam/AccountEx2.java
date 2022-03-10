package exam;

import java.util.Scanner;

public class AccountEx2 {
	
	private static Account2[] acc = new Account2[100];
	private static Scanner sc = new Scanner(System.in);
	private static int userCount = 0;
	
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			showMenu();
			switch(Integer.parseInt(sc.nextLine())) {
				case 1:
					createAccount();
					break;
				case 2:
					accountList();
					break;
				case 3:
					deposit();
					break;
				case 4:
					withdraw();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;
				default :
					System.out.println("잘못된 메뉴입니다. 다시선택해주세요.");
					break;
			}
		}
		sc.close();
	}
	
	static public void showMenu() {
		System.out.println("====================================================");
		System.out.println("1 . 생성");
		System.out.println("2 . 목록");
		System.out.println("3 . 예금");
		System.out.println("4 . 출금");
		System.out.println("0 . 종료");
		System.out.println("====================================================");
		System.out.print("메뉴를 선택해주세요 > ");
	}
	
	// 생성
	private static void createAccount() {
		int randAno = (int)(Math.random() * 999998);
		while(randAno <= 100000) {
			randAno = (int)(Math.random() * 999998);
		}
		String ano = "110-192-" + randAno;
		System.out.print("이름 > ");
		acc[userCount] = new Account2(ano, sc.nextLine(), 0);
		userCount++;
		
//		System.out.print("계좌번호 > ");
//		String ano = sc.nextLine();
//		System.out.print("계좌주 > ");
//		String owner = sc.nextLine();
//		System.out.print("잔액 > ");
//		int balance = Integer.parseInt(sc.nextLine());

				// 객체 생성 후 배열에 담기
		//		Account2 account = new Account2(ano, owner, balance);
		//		acc[0] = account;
				
				// 배열 인덱스 문제 해결 필요 (고정값이 들어가면 안된다.)
		//		acc[0] = new Account2(ano, owner, balance);
		
//		for(int i = 0; i < acc.length; i++) {
//			if(acc[i] == null) {
//				acc[i] = new Account2(ano, owner, balance);
//				System.out.println("계좌생성 완료");
//				break;
//			}
//		}
	}

	// 목록
	private static void accountList() {
		System.out.println("--------------------------------");
		System.out.println("이름\t계좌번호\t\t잔고");
		System.out.println("--------------------------------");
		for(Account2 i : acc) {
			if(i != null) {
				System.out.println(i.getOwner() + "\t" + i.getAno() + "\t" + i.getBalance());
			}
		}
	}

	// 예금
	private static void deposit() {
		System.out.print("계좌번호 > ");
		String ano = sc.nextLine();
		Account2 userAcc = findAccount(ano);
		if(userAcc != null) {
			System.out.print("입금액 > ");
			int deposit = Integer.parseInt(sc.nextLine());
			if(deposit > 0) {
				userAcc.setBalance(userAcc.getBalance() + deposit);
			}else {
				System.out.println("0 보다 큰 수를 입력해주세요.");
				return;
			}
		}else {
			System.out.println("존재하지 않는 계좌입니다.");
		}
	}

	// 출금
	private static void withdraw() {
		System.out.print("계좌번호 > ");
		String ano = sc.nextLine();
		Account2 userAcc = findAccount(ano);
		if(userAcc != null) {
			System.out.print("출금액 > ");
			int withdraw = Integer.parseInt(sc.nextLine());
			if(withdraw > 0) {
				if(userAcc.getBalance() - withdraw >= 0) {
					userAcc.setBalance(userAcc.getBalance() - withdraw);
				}else {
					System.out.println("잔액이 부족합니다. 현재 잔고는 " + userAcc.getBalance() + " 입니다.");
					return;
				}
			}else {
				System.out.println("0 보다 큰 수를 입력해주세요.");
				return;
			}
		}else {
			System.out.println("존재하지 않는 계좌입니다.");
		}
	}

	// Account2 배열에서 ano와 동일한 Account 찾기
	private static Account2 findAccount(String ano) {
		for(Account2 i : acc) {
			if(i != null) {
				if(ano.equals(i.getAno())) {
					return i;
				}
			}
		}
		return null;
	}
}
