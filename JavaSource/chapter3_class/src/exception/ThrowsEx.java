package exception;

public class ThrowsEx {
	public static void main(String[] args) {
		
		Exception e1;
		
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 호출하는 곳으로 예외를 떠넘김
	public static void findClass() throws ClassNotFoundException {
		Class cls = Class.forName("java.lang.String2");
	}
}
