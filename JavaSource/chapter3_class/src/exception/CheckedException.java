package exception;

/*
	throws : 예외 떠넘기기
		throws 예외클래스명
*/

public class CheckedException {
	public static void main(String[] args) throws ClassNotFoundException {
		
		// Unhandled exception type ClassNotFoundException
		
		Class.forName(null);
	}
}
