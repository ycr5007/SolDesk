package exception;

public class NullPointerExceptionEx {
	public static void main(String[] args) {
		ManageAccount[] account = new ManageAccount[2];
		
		System.out.println(account[0].getAccountNumber()); // java.lang.NullPointerException
	}
}
