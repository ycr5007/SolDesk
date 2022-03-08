package access;

public class AccountEx {
	public static void main(String[] args) {
		Account account = new Account("1111-22-33333" , "홍길동", 55555);
		System.out.println("계좌번호 : " + account.getAccountNumber()); 
		System.out.println("예금주 : " + account.getOwner()); 
		System.out.println("잔고 : " + account.getBalance()); 
		/*
			Account 의 멤버변수가 private 로 설정되어있어, 변수를 직접 불러오는 것이 불가하다.
		*/
		
	}
}
