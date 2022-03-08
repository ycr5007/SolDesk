package access;

/*
	클래스 접근 제한자
		▶ 목적
			> 객체 생성을 막아야 하는 경우
			> 특정 메소드를 호출 못하도록 하는 경우
			> 객체의 속성을 외부에서 함부로 변경하지 못하게 하는 경우
		▶ 종류
			> private < default(package) < protected < public
				public 		: 어디서나 접근이 가능하다( 같은 패키지, 다른 패키지 )
				protected	: 
				default		: 같은 패키지 내부에서만 접근이 가능하다
				private		: 같은 클래스 내부에서만 접근할 수 있다.
				
	변수의 접근 제한 (접근제한자 모두 사용 가능)
		▶ private : 같은 클래스에서만 접근 가능, (같은 패키지, 다른 패키지 모두 접근 불가)
			멤버변수의 private로 인해 다른 패키지에서 접근이 불가하여 변수를 불러오기 위한 특수한 메소드를 사용한다.
				getter : 변수값을 리턴
				setter : 변수값을 저장
*/

public class Account {
	private String accountNumber;
	private String owner;
	private int balance;
	
	public Account(String accountNumber, String owner, int balance) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
		System.out.println(owner + "님, 계좌번호 (" + accountNumber + ")로 계좌신설 되었습니다.");
	}

	int deposit(int amount) {
		balance += amount;
		return balance;
	}

	int withdraw(int amount) {
		balance -= amount;
		return balance;
	}

	// private 로 인해 직접접근이 불가하여, 멤버변수를 불러오기 위한 getter 메소드
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public int getBalance() {
		return balance;
	}

	// private 로 인해 직접접근이 불가하여, 멤버변수 수정을 위한 setter 메소드 (매개값의 유효성을 검증한 후 변경)
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
