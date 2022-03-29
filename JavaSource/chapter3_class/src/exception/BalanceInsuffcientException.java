package exception;

/*
	사용자 정의 예외
*/

public class BalanceInsuffcientException extends Exception {

	/*
		serialVersionUID > 무시 가능
	*/
	private static final long serialVersionUID = 1L;
	
	public BalanceInsuffcientException() {
		
	}

	public BalanceInsuffcientException(String message) {
		super(message);
	}
}
