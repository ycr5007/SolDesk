package op;

/*
	== : 같음
	!= : 같지 않음
*/

public class LogicalOperatorEx2 {
	public static void main(String[] args) {
		int charCode = 'A';
		
		if((charCode >= 65) && (charCode <= 90)) {
			System.out.println("대문자");
		}

		if(!(charCode < 48) && !(charCode > 57)) {
			System.out.println("숫자");
		}
		
		int value = 6;
		if((value % 2 == 0) || (value % 3 == 0)) {
			System.out.println("2와 3의 공배수");
		}
	}
}
