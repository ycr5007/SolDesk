package op;

	// equals : 문자열 및 객체 비교

public class CompareOperatorEx2 {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = new String("홍길동");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		
		System.out.println();
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
	}
}
