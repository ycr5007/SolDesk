package exception;

public class UnCheckedException {
	public static void main(String[] args) {
		String str[] = new String[2];
		
		System.out.println(str[3]); // java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
	}
}
