package classtest;

public class Card {
	
	// 객체별로 다른 값을 갖는 속성 ( 멤버 변수 )
	String kind;
	int number;
	
	// 모든 객체가 갖는 공통된 속성 ( 클래스 변수 )
	static int width = 100;
	static int height = 150;

		// 생성자에는 클래스변수가 포함되지 않는다.
	public Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}



	public static void main(String[] args) {
		
		// 객체 생성 전에도 호출 가능
		System.out.println(Card.width);
		System.out.println(Card.height);
		
		Card card1 = new Card("heart", 7);
		Card card2 = new Card("clover", 3);
		Card card3 = new Card("spade", 10);
		
		// The static field Card.width should be accessed in a static way > static 필드에 대한 올바른 접근방법으로 접근 요청 ( 클래스이름.변수명 )
		System.out.println(card1 + "\tcard1 : kind > " + card1.kind + " / number > " + card1.number + " width/height > " + card1.width + "/" + Card.height);
		System.out.println(card2 + "\tcard2 : kind > " + card2.kind + " / number > " + card2.number + " width/height > " + card2.width + "/" + Card.height);
		
		Card.width = 50;
		Card.height = 80;
		System.out.println(card3 + "\tcard3 : kind > " + card3.kind + " / number > " + card3.number + " width/height > " + card3.width + "/" + Card.height);
		
	}
}
