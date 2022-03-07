package classtest;

public class Account {
	// Property : accountNumber, owner, balance
	// Function : deposit, withdraw
	
	String accountNumber;
	String owner;
	int balance;
	
	public Account(String accountNumber, String owner, int balance) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
		System.out.println(owner + "님, 계좌번호 (" + accountNumber + ")로 계좌신설 되었습니다.");
	}

	// 입금액을 입력받아 현재 잔액에 추가
	int deposit(int amount) {
		balance += amount;
		return balance;
	}

	// 출금액을 입력받아 현재 잔액에 감소
	int withdraw(int amount) {
		balance -= amount;
		return balance;
	}
	
	public static void main(String[] args) {
		Account account1 = new Account("111-11-11111", "천원짜리", 1000);
		Account account2 = new Account("222-22-22222", "오천원짜리", 5000);
		
		System.out.println(account1.owner + "의 현재 잔액 : " + account1.withdraw(500));

		System.out.println(account2.owner + "의 현재 잔액 : " + account2.deposit(500));
	}
}
