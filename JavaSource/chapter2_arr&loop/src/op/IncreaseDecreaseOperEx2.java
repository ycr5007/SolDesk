package op;

/*
	증감연산자는 앞, 뒤 어디에나 올 수 있음
	하지만, 대입연산자랑 만날 때 앞 쪽에 오는 경우는 증감을 먼저 하고 대입이 일어남
							뒤 쪽에 오는 경우는 대입을 하고 증감이 일어남
	
	int result1 = ++x + 20;
	① > ++x
	② > ① + 20
	③ > =(대입) 연산자 실행 => 결과 22
	
	int result1 = x++ + 20;
	① > x + 20
	② > =(대입) 연산자 실행 => 결과 21
	③ > x++
*/

public class IncreaseDecreaseOperEx2 {
	public static void main(String[] args) {
		int x = 1;
		int y = 1;
		// int result1 = ++x + 20;
		int result1 = x++ + 20;
		// System.out.println("++x result1 : " + result1); 22
		System.out.println("x++ result1 : " + result1);
		// int result2 = --y + 20;
		int result2 = y-- + 20;
		// System.out.println("--y result2 : " + result2); 20
		System.out.println("y-- result2 : " + result2);
	}
}
