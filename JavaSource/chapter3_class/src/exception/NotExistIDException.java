package exception;

public class NotExistIDException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NotExistIDException() {
		
	}
	public NotExistIDException(String message) {
		super(message);
	}
}
