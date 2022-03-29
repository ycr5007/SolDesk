package exception;

public class WrongPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongPasswordException() {

	}

	public WrongPasswordException(String message) {
		super(message);
	}
	
}
