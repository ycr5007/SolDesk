package exam;

/*
	잔고(balance) 필드
		외부에서 balace 필드를 마음대로 변경하지 못한다.
		잔고필드는 음수값이 될 수 없고, 최대 1,000,000 까지만 저장 가능하다.
		
	getter/setter 사용
	0, 1,000,000 은 MIN_BALANCE 와 MAX_BALACNE 상수로 선언
	setter 의 매개값이 음수이거나 1,000,000 을 초과하면 현재 balance 값 유지	
*/

public class Account1 {
	private int balance;
	static final int MAX_BALANCE = 1000000;
	static final int MIN_BALANCE = 0;
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance <= MIN_BALANCE || balance >= MAX_BALANCE) {
			System.out.println("0 ~ 1,000,000 사이 값을 입력해주세요.");
		}else {
			this.balance = balance;
			System.out.println("정상적으로 반영되었습니다. 현재 잔고는 " + this.balance + " 입니다.");
		}
	} 
	
	public void depositBalance(int balance) {
		if((this.balance + balance) >= MAX_BALANCE) {
			System.out.println("입금 한도금액을 초과했습니다. 현재 잔고는 " + this.balance + " 입니다.");
		}else {
			this.balance = this.balance + balance;
			System.out.println("정상적으로 반영되었습니다. 현재 잔고는 " + this.balance + " 입니다.");
		}
	}
	public void withdrawBalance(int balance) {
		if((this.balance - balance) <= MIN_BALANCE){
			System.out.println("잔액이 부족합니다. 현재 잔고는 " + this.balance + " 입니다.");
		}else {
		this.balance = this.balance - balance;
		System.out.println("정상적으로 반영되었습니다. 현재 잔고는 " + this.balance + " 입니다.");
		}
	}
}
