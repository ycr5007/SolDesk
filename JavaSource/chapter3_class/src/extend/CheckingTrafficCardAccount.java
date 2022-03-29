package extend;

/*
					상속 관계
					Object
						↑
					Account
						↑
					CheckingAccount
						↑
					CheckingTrafficCardAccount
*/

public class CheckingTrafficCardAccount extends CheckingAccount{

	// 교통카드 기능(t/f) : hasTrafficCard
	
	private boolean hasTrafficCard;
	
	public CheckingTrafficCardAccount(String accountNumber, String owner, int balance, String cardNo, boolean hasTrafficCard) {
		super(accountNumber, owner, balance, cardNo);
		this.hasTrafficCard = hasTrafficCard;
	}
	
	/*
		payTrafficCard()
		교통비 지불
		cardNo, 교통카드 사용액을 매개변수로 받는다
		교통카드 기능이 있는지 확인한다.
		cardNo 와 사용액을 활용하여 부모클래스의 pay 호출
	*/
	
	int payTrafficCard(String cardNo, int amount) {
		if(!(hasTrafficCard)) {
			System.out.println("교통카드 기능이 없습니다.");
			return -1;
		}
		return this.pay(cardNo, amount);
	}
	
}
