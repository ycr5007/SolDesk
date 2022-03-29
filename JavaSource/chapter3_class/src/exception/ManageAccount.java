package exception;

public class ManageAccount {
	private String accountNumber;
	private String owner;
	private int balance;
	
	public ManageAccount(String accountNumber, String owner, int balance) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
		System.out.println(owner + "님, 계좌번호 (" + accountNumber + ")로 계좌신설 되었습니다.");
	}

	int deposit(int amount) {
		balance += amount;
		return balance;
	}

//	int withdraw(int amount) throws BalanceInsuffcientException {
//		if(balance < amount) {
//			// 예외 강제 발생
//			throw new BalanceInsuffcientException("잔고부족 : " + (amount - balance) + "부족");
//		}
//		balance -= amount;
//		return balance;
//	}
	
	int withdraw(int amount) throws Exception {
		if(balance < amount) {
			// 예외 강제 발생
			throw new Exception("잔고부족 : " + (amount - balance) + "부족");
		}
		balance -= amount;
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
