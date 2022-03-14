package exception;

public class ManageAccountEx {
	
	public static void main(String[] args) throws Exception {
		ManageAccount account = new ManageAccount("111", "홍길동", 200000);
		try {
			account.withdraw(300000);
		} catch (BalanceInsuffcientException e) {
			e.printStackTrace();
		}
	}
	
}
