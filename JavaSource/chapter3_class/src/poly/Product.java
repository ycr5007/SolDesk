package poly;

public class Product {
	int price;
	int bonusPoint;
	
	static int sale;
	
	public Product(int price) {
		this.price = price;
		bonusPoint = (int)(price / 10.0);
	}
	
	
}
