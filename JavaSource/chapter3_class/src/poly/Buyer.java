package poly;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	
	Product[] items = new Product[10];
	Computer[] com = new Computer[10];
	TV[] tv = new TV[10];
	//		... ( 끝없이 추가될 가능성이 있음 )
	int i = 0;
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액부족으로 물건 구매 불가");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		Product.sale += p.price;
		items[i++] = p;
		System.out.println(p + "를 구매하였습니다.");
	}
	
	
	// > 오버로딩 개념으로 작성은 가능하나, 효율이 떨어짐 ( 부모클래스를 매개변수로 받을 경우 작업 처리가 용이해진다. )
//	void buy(TV p) {
//		if(money < p.price) {
//			System.out.println("잔액부족으로 물건 구매 불가");
//			return;
//		}
//		
//		money -= p.price;
//		bonusPoint += p.bonusPoint;
//		Product.sale += p.price;
//		System.out.println(p + "를 구매하였습니다.");
//	}
//	
//	void buy(Computer p) {
//		if(money < p.price) {
//			System.out.println("잔액부족으로 물건 구매 불가");
//			return;
//		}
//		
//		money -= p.price;
//		bonusPoint += p.bonusPoint;
//		Product.sale += p.price;
//		System.out.println(p + "를 구매하였습니다.");
//	}
}
