package exception;

public class NumberFormatExceptionEx {
	public static void main(String[] args) {
		String data1 = "a100";
		String data2 = "100";
		
		try {
			int value1 = Integer.parseInt(data1); // a100 변경 불가
			
			// 위에서 예외 발생으로 catch 문으로 이동
			System.out.println("data1 을 변경하는데 실패했습니다.");
			int value2 = Integer.parseInt(data2); // 정상변경
			System.out.println("data2 를 변경했습니다.");
			
			System.out.println(value1 + value2); // java.lang.NumberFormatException
		} catch (Exception e) {
			System.out.println("NumberFormat Exception Catch Code");
			e.printStackTrace();
		} finally { // 예외와 상관없이 무조건 실행해야하는 코드
			System.out.println("Finally Code");
		}
	}
}
