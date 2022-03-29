package exam;

/*
	Property : 계좌번호(ano), 예금주(owner), 잔액(balance)
		외부 접근 불가
		
	생성자 : 3개 속성 초기화
	
	getter / setter
*/

public class Account2 {
	
	private String ano;
	private String owner;
	private int balance;
	
	public Account2(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
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
}
