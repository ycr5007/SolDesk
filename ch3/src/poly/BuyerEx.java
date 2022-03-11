package poly;

public class BuyerEx {
	public static void main(String[] args) {
		Buyer buyer = new Buyer();

		
		System.out.println(Product.sale);
		
		buyer.buy(new Computer());
		buyer.buy(new TV());
		buyer.buy(new Audio());
		buyer.buy(new Computer());
		buyer.buy(new Audio());
		buyer.buy(new TV());
		
		
		System.out.println(Product.sale);
		
		System.out.println("현재 잔액 " + buyer.money);
		System.out.println("현재 보너스 포인트 " + buyer.bonusPoint);
		
		for(Product p : buyer.items) {
			if(p != null) {
				System.out.println(p);
			}
		}
	}
}
