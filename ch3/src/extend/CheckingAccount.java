package extend;

public class CheckingAccount extends Account{
	
	private String cardNo;
	
	public CheckingAccount(String accountNumber, String owner, int balance, String cardNo) {
		super(accountNumber, owner, balance);
		this.cardNo = cardNo;
	}
	
	/*
		직불카드 사용액을 지불한다
		매개인자로 직불카드번호와 사용액을 받아서 카드번호 일치여부 및 은행 잔고와 비교한 후 지불
	*/
	
	
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public int pay(String cardNo, int amount) {
		if(cardNo.equals(this.cardNo)) {
			if((this.getBalance() - amount) > 0) {
				System.out.println(amount + "원 결제가 완료되었습니다.");
				return withdraw(amount); // 부모클래스의 메소드 활용
			}else {
				System.out.println("잔액이 부족합니다.");
				return -1;
			}
		}else {
			System.out.println("카드번호가 일치하지 않습니다.");
			return -1;
		}
	}

}
