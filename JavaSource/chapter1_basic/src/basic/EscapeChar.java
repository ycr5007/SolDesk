package basic;

/*
	EscapeChar
		\n : 줄 바꿈 (Enter)
		\t : 간격 띄우기 (Tab)
		
		\ : 다음 문자 Escape
		
	출력문
		System.out.println(); > 출력 후 개행(ln)을 한다
		System.out.print(); > 개행없이 출력만 진행한다.
		System.out.printf(); > 서식문자를 통해 값을 대입한다
*/

public class EscapeChar {
	public static void main(String[] args) {
		
		System.out.println("안녕하세요\n안녕못해요");
		System.out.println("안녕하세요\t안녕못해요");
		
		System.out.println("'Hello'");
		
		// System.out.println(""Hello""); // Syntax error on token "Hello", invalid AssignmentOperator : ( " " 열고 닫힘이 반복되어 Hello를 포함하지 못하여 에러 발생 )
		System.out.println("\"Hello\""); // double quote 를 출력문에 포현하고 싶을 땐 " \" " 로 Escape 시켜야 한다.
		
		System.out.print("Hello\n\n\n");
		System.out.print("Wor\tld");
		
		// System.out.println("c:\"); // String literal is not properly closed by a double-quote : ( " \ " 로 뒤에있는 double-quote Escape 되었기 때문에, 닫히지 않은것으로 에러발생 )
		System.out.println("C:\\"); // Escape는 다음 한 문자를 Escape 시키기 때문에 " \ " 를 출력하고 싶을 경우, " \\ " 로 출력하면 된다.
	}
}
