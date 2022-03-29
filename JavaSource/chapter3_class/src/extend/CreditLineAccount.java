package extend;

public class CreditLineAccount extends Account{

	// 마이너스 한도 : creditLine
	
	private int creditLine;
	
	public CreditLineAccount(String accountNumber, String owner, int balance, int creditLine) {
		super(accountNumber, owner, balance);
		this.creditLine = creditLine;
	}

	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}
	
	
	/*
		잔액 = 잔액 + 마이너스 한도
	*/
	@Override
	int withdraw(int amount) {
		if((super.getBalance() + creditLine) > amount) {
			setBalance(getBalance() - amount);
			return getBalance();
		}else {
			System.out.println("잔액이 부족합니다.");
			return -1;
		}
	}
}
