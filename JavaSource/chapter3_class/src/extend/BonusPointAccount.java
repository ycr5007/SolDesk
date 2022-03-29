package extend;

public class BonusPointAccount extends Account {

	// 보너스포인트 (int) : bonusPoint
	private int bonusPoint;
	
	
	public BonusPointAccount(String accountNumber, String owner, int balance) {
		super(accountNumber, owner, balance);
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	// 예금 > 보너스포인트(예금액 * 0.1%)
	@Override
	int deposit(int amount) {
		super.deposit(amount);
		bonusPoint = (int)(amount * 0.001);
		return bonusPoint;
	}
}
