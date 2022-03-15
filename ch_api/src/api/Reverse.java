package api;

/*
	거꾸로 출력
*/

public class Reverse {
	public static void main(String[] args) {
		String str = "ABzquartK";
		String reverseStr = reverse(str);
		System.out.println(reverseStr);
		
		StringBuilder builder = new StringBuilder(str);
		builder.reverse();
		String reverseString = new String(builder);
		System.out.println(reverseString);
	}
	
	public static String reverse(String src) {
		char[] tempArr = new char[src.length()];
		for(int i = tempArr.length - 1, j = 0; i >= 0; i--, j++) {
			tempArr[i] = src.charAt(j);
		}
		return new String(tempArr);
	}
	
	public static String reverseHY(String src) {
		char ch[] = new char[src.length()];
		
		for(int i = 0; i < src.length(); i++) {
			ch[i] = src.charAt((src.length() - 1) - i);
		}
		return new String(ch);
	}
	
	public static String reverseAnswer1(String src) {
		String str = "";
		for(int i = src.length() - 1; i >= 0; i--) {
			str += src.charAt(i);
		}
		return str;
	}
	
	public static void reverseAnswer2(String src) {
		char[] chArr = src.toCharArray();
		for(int i = chArr.length - 1; i >= 0; i--) {
			System.out.print(chArr[i]);
		}
	}
	
}
