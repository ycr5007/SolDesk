package extend;

/*
	CheckingAccount
		Account + 체크카드 기능
	CheckingTrafficCardAccount
		Account + 체크카드 기능 + 교통카드 기능
	CreditLineAccount
		Account + 마이너스 기능
	BonusPointAccount
		Account + 보너스 포인트 (예금액당 보너스)
*/

public class Account {
	
	private String accountNumber;
	private String owner;
	private int balance;
	
	public Account(String accountNumber, String owner, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	int deposit(int amount) {
		balance += amount;
		return balance;
	}

	int withdraw(int amount) {
		balance -= amount;
		return balance;
	}
}
