package extend;

public class AccountEx {
	public static void main(String[] args) {
		CheckingAccount checkCard1 = new CheckingAccount("110-112-125532", "민병관", 50000, "1111-2222-3333-4444");
		CheckingAccount checkCard2 = new CheckingAccount("110-112-145231", "정상태", 20000, "2222-3333-4444-5555");
		
		System.out.println("======================================CheckingAccout1======================================");
		
		checkCard1.deposit(30000);
		System.out.println(checkCard1.getOwner() + "님의 현재 잔액은 " + checkCard1.getBalance() + " 입니다.");
		checkCard1.pay("1111-2222-3333-4444", 40000);
		System.out.println(checkCard1.getOwner() + "님의 현재 잔액은 " + checkCard1.getBalance() + " 입니다.");
		
		System.out.println("======================================CheckingAccout2======================================");
		
		checkCard2.withdraw(5000);
		System.out.println(checkCard2.getOwner() + "님의 현재 잔액은 " + checkCard2.getBalance() + " 입니다.");
		checkCard2.pay("2222-3333-4444-5556", 7000);
		System.out.println(checkCard2.getOwner() + "님의 현재 잔액은 " + checkCard2.getBalance() + " 입니다.");

		System.out.println("=================================CheckingTrafficCardAccout1=================================");
		
		CheckingTrafficCardAccount ckTrafficCard1 = new CheckingTrafficCardAccount("110-112-223452", "홍록기", 35000, "3333-4444-5555-6666", true);
		CheckingTrafficCardAccount ckTrafficCard2 = new CheckingTrafficCardAccount("110-112-224584", "정태철", 70000, "4444-5555-6666-7777", false);
		
		ckTrafficCard1.deposit(15000);
		System.out.println(ckTrafficCard1.getOwner() + "님의 현재 잔액은 " + ckTrafficCard1.getBalance() + " 입니다.");
		ckTrafficCard1.pay("3333-4444-5555-6666", 13000);
		ckTrafficCard1.payTrafficCard("3333-4444-5555-6666", 1300);
		System.out.println(ckTrafficCard1.getOwner() + "님의 현재 잔액은 " + ckTrafficCard1.getBalance() + " 입니다.");

		System.out.println("=================================CheckingTrafficCardAccout2=================================");
		
		ckTrafficCard2.withdraw(15000);
		System.out.println(ckTrafficCard2.getOwner() + "님의 현재 잔액은 " + ckTrafficCard2.getBalance() + " 입니다.");
		ckTrafficCard2.pay("4444-5555-6666-7777", 5000);
		ckTrafficCard2.payTrafficCard("4444-5555-6666-7777", 1300);
		System.out.println(ckTrafficCard2.getOwner() + "님의 현재 잔액은 " + ckTrafficCard2.getBalance() + " 입니다.");

		CreditLineAccount creditCard1 = new CreditLineAccount("110-112-334635", "홍민기", 50000, 1000000);
		CreditLineAccount creditCard2 = new CreditLineAccount("110-112-335667", "홍합탕", 3000, 1000000);
		
		System.out.println("=================================CreditLineAccount1=================================");
		
		creditCard1.deposit(300000);
		System.out.println(creditCard1.getOwner() + "님의 현재 잔액은 " + creditCard1.getBalance() + " 입니다.");
		creditCard1.withdraw(800000);
		System.out.println(creditCard1.getOwner() + "님의 현재 잔액은 " + creditCard1.getBalance() + " 입니다.");

		System.out.println("=================================CreditLineAccount2=================================");

		System.out.println(creditCard2.getOwner() + "님의 현재 잔액은 " + creditCard2.getBalance() + " 입니다.");
		creditCard2.withdraw(1100000);
		System.out.println(creditCard2.getOwner() + "님의 현재 잔액은 " + creditCard2.getBalance() + " 입니다.");

		BonusPointAccount bonusAccount1 = new BonusPointAccount("110-112-446604", "나문희", 50000);
		
		System.out.println("=================================bonusAccount1=================================");
		
		System.out.println(bonusAccount1.getOwner() + "님의 현재 잔액은 " + bonusAccount1.getBalance() + " 입니다.");
		bonusAccount1.deposit(50000);
		System.out.println("bonusAccount1 의 bonusPoint : " + bonusAccount1.getBonusPoint());
		System.out.println(bonusAccount1.getOwner() + "님의 현재 잔액은 " + bonusAccount1.getBalance() + " 입니다.");
	}
}
