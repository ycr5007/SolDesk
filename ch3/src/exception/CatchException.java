package exception;

public class CatchException {
	public static void main(String[] args) {
		try {
			// ArrayIndexOutOfBoundsException 발생 예상
			String data1 = "100a";
			String data2 = args[1];
			
			// NumberFormatException 발생 예상
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			
			// Exception 모든 Exception의 부모클래스
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("ArrayIndexOutOfBounds Exception | NumberFormat Exception 에러 발생");
			e.printStackTrace();
		}
		
		/*
			try {
			
			}	catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("ArrayIndexOutOfBounds Exception 발생입니다.");
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("NumberFormat Exception 발생입니다.");
				e.printStackTrace();
			}
		*/
	}
}
